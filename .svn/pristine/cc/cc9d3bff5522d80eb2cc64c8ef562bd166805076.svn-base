package cn.xaut.shop.pojo;

import java.util.Iterator;
import java.util.List;

public class Page<T> implements Iterable<T> {

	private List<T> list = null; // Ҫ���ص�ĳһҳ�ļ�¼�б�

	private int allRow; // �ܼ�¼��
	private int totalPage; // ��ҳ��
	private int currentPage; // ��ǰҳ
	private int pageSize; // ÿҳ��¼��

	private boolean isFirstPage; // �Ƿ�Ϊ��һҳ
	private boolean isLastPage; // �Ƿ�Ϊ���һҳ
	private boolean hasPreviousPage; // �Ƿ���ǰһҳ
	private boolean hasNextPage; // �Ƿ�����һҳ

	public Page() {

	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��ʼ����ҳ��Ϣ
	 */
	public void init() {
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
		this.hasPreviousPage = isHasPreviousPage();
		this.hasNextPage = isHasNextPage();
	}

	/**
	 * �����ж�ҳ����Ϣ,ֻ��getter����(is����)����
	 * 
	 * @return
	 */

	public boolean isFirstPage() {
		// return currentPage == 1; // ���ǵ�ǰҳ�ǵ�1ҳ
		return !isHasPreviousPage();
	}

	public boolean isLastPage() {
		// return currentPage == totalPage; //���ǰҳ�����һҳ
		return !isHasNextPage();
	}

	public boolean isHasPreviousPage() {
		// return currentPage != 1; //ֻҪ��ǰҳ���ǵ�1ҳ
		return (getCurrentPage() > 1);
	}

	public boolean isHasNextPage() {
		// return currentPage != totalPage; //ֻҪ��ǰҳ�������1ҳ
		return (getCurrentPage() + 1 <= getTotalPage());
	}

	/**
	 * ������ҳ��,��̬����,���ⲿֱ��ͨ���������
	 * 
	 * @param pageSize
	 *            ÿҳ��¼��
	 * @param allRow
	 *            �ܼ�¼��
	 * @return ��ҳ��
	 */
	public static int countTotalPage(final int pageSize, final int allRow) {
		int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow
				/ pageSize + 1;
		return totalPage;
	}

	/**
	 * ���㵱ǰҳ��ʼ��¼
	 * 
	 * @param pageSize
	 *            ÿҳ��¼��
	 * @param currentPage
	 *            ��ǰ�ڼ�ҳ
	 * @return ��ǰҳ��ʼ��¼��
	 */
	public static int countOffset(final int pageSize, final int currentPage) {
		final int offset = pageSize * (currentPage - 1);
		return offset;
	}

	/**
	 * ���㵱ǰҳ,��Ϊ0���������URL��û��"?page=",����1����
	 * 
	 * @param page
	 *            ����Ĳ���(����Ϊ��,��0,�򷵻�1)
	 * @return ��ǰҳ
	 */
	public static int countCurrentPage(int page) {
		final int curPage = (page == 0 ? 1 : page);
		return curPage;
	}

	/**
	 * ȡ����ҳ��ҳ��, ��Ŵ�1��ʼ. ��ǰҳΪ��ҳʱ������ҳ���.
	 */
	public int getPrePage() {
		if (isHasPreviousPage()) {
			return getCurrentPage() - 1;
		} else {
			return getCurrentPage();
		}
	}

	/**
	 * ȡ����ҳ��ҳ��, ��Ŵ�1��ʼ. ��ǰҳΪβҳʱ�Է���βҳ���.
	 */
	public int getNextPage() {
		if (isHasNextPage()) {
			return getCurrentPage() + 1;
		} else {
			return getCurrentPage();
		}
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
