package cn.xaut.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import org.apache.struts2.ServletActionContext;
public class FileUploadUtil {

	private String filePath ="";

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	private String getExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	private String createFileName(String fileName) {
		//Date now = new Date();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");//可以方便地修改日期格式
		//String file=fileName.substring(0,fileName.lastIndexOf(".")-1)+dateFormat.format(now);
		//System.out.println(file);
		//return file + "." + getExt(fileName);
		return UUID.randomUUID().toString() + "." + getExt(fileName);
	}
	
	@SuppressWarnings("deprecation")
	public void delete(String fileName)
	{
		fileName=ServletActionContext.getRequest().getRealPath("")+fileName;
		System.out.println(fileName);
		new File(fileName).delete();
	}

	//自定义上传路径
	//file 需要上传文件的路径信息     
    //fileName 上传文件的文件名
	//path 此路径为工程的相对路径
	public String uploadFile(File file, String fileName, String path) {
		if (path != null) {
			judgepath(path);
		}
		return this.uploadFile(file, fileName);
	}
	
	//判断自定义路径是否存在，不存在就创建路径
	//此路径为电脑的绝对路径
	public void judgepath(String path)
	{
		@SuppressWarnings("deprecation")
		String projectPath = ServletActionContext.getRequest().getRealPath("");
		String[] dir=path.split("/");
		for(int i=0;i<dir.length;i++)
		{
			projectPath=projectPath+"//"+dir[i];
			File file =new File(projectPath);    
			//如果文件夹不存在则创建    
			if  (!file .exists()  && !file .isDirectory())      
			{       
			    System.out.println("//不存在");  
			    file .mkdir();
			} else   
			{  
			    System.out.println("//目录存在");  
			}  
		}
		filePath = projectPath;
	}
	
	
	//file 为上传文件的路径信息     
		//fileName 上传文件的文件名
	@SuppressWarnings("deprecation")
	public String uploadFile(File file, String fileName) {
		// 生成新名称
		String newName = createFileName(fileName);
		if(filePath.equals(""))
		{
			filePath=ServletActionContext.getRequest().getRealPath("");
		}

		System.out.println(filePath);
		System.out.println(newName);
		// 文件上传
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(filePath + "/" + newName);
			byte[] b = new byte[1024];
			int length = 0;
			while ((length = input.read(b)) != -1) {
				output.write(b, 0, length);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					output.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		filePath="";
		//return path + "/" + newName;
		return newName;
	}

	public String[] bankImage(String path) {
		
		// 获取指定位置目录
		File file = new File(path);
		return  file.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				// 判读后缀名
				return name.endsWith("gif");
				// 返回false表示被过滤掉
			}
		});
	}
	
	public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }
	
	public static void downloadFile(URL theURL, String filePath,String filename) throws IOException {  
	     File dirFile = new File(filePath);
	        if(!dirFile.exists()){//文件路径不存在时，自动创建目录
	          dirFile.mkdir();
	        }
	   //从服务器上获取图片并保存
	      URLConnection  connection = theURL.openConnection();
	      InputStream in = connection.getInputStream();  
	      FileOutputStream os = new FileOutputStream(filePath+filename); 
	      byte[] buffer = new byte[4 * 1024];  
	      int read;  
	      while ((read = in.read(buffer)) > 0) {  
	          os.write(buffer, 0, read);  
	           }  
	        os.close();  
	        in.close();
	   }   
	@SuppressWarnings("deprecation")
	public static void download(String path, String filePath,String filename) throws IOException {  
	     File dirFile = new File(filePath);
	        if(!dirFile.exists()){//文件路径不存在时，自动创建目录
	          dirFile.mkdir();
	        }
	   //从服务器上获取图片并保存
	      path=ServletActionContext.getRequest().getRealPath("") +"/" + path;
	      FileInputStream in = new FileInputStream(path);
	      FileOutputStream os = new FileOutputStream(filePath+filename); 
	      byte[] buffer = new byte[4 * 1024];  
	      int read;  
	      while ((read = in.read(buffer)) > 0) {  
	          os.write(buffer, 0, read);  
	           }  
	        os.close();  
	        in.close();
	   }   
	
	        //file 为上传文件的路径信息     ywl
			//fileName 上传文件的文件名
		@SuppressWarnings("deprecation")
		public String uploadFileForRealName(File file, String fileName) {			
			if(filePath.equals(""))
			{
				filePath=ServletActionContext.getRequest().getRealPath("")+"/upload/shopapply";
				 File dirFile = new File(filePath);
			        if(!dirFile.exists()){//文件路径不存在时，自动创建目录
			          dirFile.mkdir();
			        }
			}
			//System.out.println(filePath);
			// 文件上传
			InputStream input = null;
			OutputStream output = null;
			try {
				input = new FileInputStream(file);
				output = new FileOutputStream(filePath + "/" + fileName);
				byte[] b = new byte[1024*1024];
				int length = 0;
				while ((length = input.read(b)) != -1) {
					output.write(b, 0, length);
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				} finally {
					try {
						output.close();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
			String path=filePath;
			filePath="";
			
			//return path + "/" + fileName;
			return  "/upload/shopapply/" + fileName;
		}
		 //ywl
		public static void downloadbyRealName(String path, String filePath,String filename) throws IOException { 
			@SuppressWarnings("deprecation")
			String filePath2=ServletActionContext.getRequest().getRealPath("")+"/upload/shopapply/download/";//暂时没用filePath，方便部署
		     File dirFile = new File(filePath2);
		        if(!dirFile.exists()){//文件路径不存在时，自动创建目录
		          dirFile.mkdir();
		        }
		   //从服务器上获取图片并保存
		      FileInputStream in = new FileInputStream(path);
		      FileOutputStream os = new FileOutputStream(filePath2+filename); 
		      byte[] buffer = new byte[1024*4];  
		      int read;  
		      while ((read = in.read(buffer)) > 0) {  
		          os.write(buffer, 0, read);  
		           }  
		        os.close();  
		        in.close();
		   }   
}
