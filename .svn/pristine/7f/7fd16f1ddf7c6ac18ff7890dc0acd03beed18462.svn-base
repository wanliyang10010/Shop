<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jspf"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>测试页面</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body {font-size: 1em;text-align: center;font-family: 'Arial', sans-serif;}
	.main{ }
	.main form input[type=text] {padding: 1em;border: 0;width: 38em;border-radius: 2px 0 0 2px;background: #efefef;opacity: 0.5;}
	.main form input[type=text]:focus {opacity: 0.9;}
  	.main ul {padding: 0;margin: 0;}
    .main ul li {margin: 1em .5em;padding: 2px;list-style-type: none;border: 1px solid transparent;border-radius: 2px;}
    .main .msg {color:red;}
    .result {text-align:center;margin-left: auto;margin-right: auto; padding:20px;}
    .result table{border:black 1px solid;border-collapse:collapse;border-spacing:0;margin: 20px auto 100px;} 
    .result	table th {border:black 1px solid;padding:0;max-width:180px;background:lightgray;}
    .result	table th,td{border:black 1px solid;padding:0;max-width:180px;}
    .result	.index {background:lightgray;}
    .tips ul {margin-left:20%;margin-right:20%;}
    .tips ul li{list-style-type:none;  text-align: left; margin:10px 0px;}
	</style>
	<script type="text/javascript" src="${ctx }/js/jQuery/jquery-1.9.0.js" /></script>
  </head>
  <body>
  	<header>
  		<div>
  			<h2>数据库测试页面</h1>
  		</div>
  	</header>
    <div>
    </div>
    <div class="main">
      <input type="hidden" id="ctx" value="${ctx}"/>
      <form id="form1" >
        <ul>
        	<li><span id="msg" class="msg">${result}</span><span id="flag" class="msg"></span></li>
        	<li>
        		<span>语言</span>
        		<input type="radio" name="lang" value="sql" checked="checked" />SQL 
				<!-- <input type="radio" name="lang" value="hql" />HQL -->
			</li>
			<li>
				<span>操作</span>
				<input type="radio" name="type" value="query" checked="checked" />查询
				<input type="radio" name="type" value="exec" />更新
			</li>
			<li>
    			<label>类名</label>
    			<input type="text" name="className" placeholder="实体类名称（选填）"/>
    		</li>
    		<li>
    			<label>语句</label>
    			<input type="text" name="command" placeholder="SQL/HQL语句，参数用？占位"/>
    		</li>
    		<li>
    			<label>参数</label>
    			<input type="text" name="params" placeholder="参数1，参数2，...参数n"/>
    		</li>
    		<li>
    			<input id="btn_ok" type="button" value="执行"/>
    		</li>
    	</ul>
      </form>
    </div>
    <div class="tips">
    	<ul>
    	<li>INSERT INTO 表名称 VALUES (值1, 值2,....)</li>
    	<li>INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)</li>
    	<li>DELETE FROM 表名称 WHERE 列名称 = 值</li>
    	<li>UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值</li>
    	<li>----------------------------------------------</li>
    	<li>alter table tablename add (column datatype [default value][null/not null],….);</li>
    	<li>alter table tablename modify (column datatype [default value][null/not null],….);</li>
    	<li>alter table tablename drop (column);</li>
    	</ul>
    </div>
    <div id="div_result" class="result">
    </div>
    
    <footer>
    
	<script type="text/javascript">
			/*
		 $(document).ready(function(){
		 	$("#btn_ok").click(function(){
		 		alert("");
		 	});
		 	
		 });*/
		 	$(function(){
		
			$("#btn_ok").click(function(){
			
				var lang = $("input:radio[name='lang']:checked").val();
				var type = $("input:radio[name='type']:checked").val();
				var url = $("#ctx").val();
				
				if(lang == "hql"){
					if(type == "exec"){
						url += "/hql/hqlAction!execHql.do";
					}
					if(type == "query"){
						url += "/hql/hqlAction!queryByHql.do";
					}
				}
				
				if(lang == "sql"){
					if(type == "exec"){
						url += "/hql/hqlAction!execSql.do";
					}
					if(type == "query"){
						url += "/hql/hqlAction!queryBySql.do";
					}
				}
				
				//url = "/MyShop/hql/hqlAction!jsonResult.do";
				
				var formParam = $("#form1").serialize();//序列化表格内容为字符串  
				$.ajax({
					type: 'POST',
					url: url ,
				    data: formParam ,
				    dataType: 'json',
				    success: function(result){
				    	$("#msg").html(result.data);
				    	$("#flag").html(" " + result.dataFlag);
				    	if(result.list.length > 0){
				    		list(result.list);
				    	}
				    },
				    error:function(){
				    	$("#msg").html("访问出错或超时");
				    }  
				});
			});
			
			
			function list(data){
				//var aToStr=JSON.stringify(data); 
				var bToObj=JSON.parse(data); 
				//alert(bToObj);
				//alert(data);
				//alert(obj);
				
				var ths = "<tr><td class='index'>序号</td>";
				var trs = "";
				$.each(bToObj, function (index, row) {
					//alert(index + '  ' + row);
					trs += "<tr><td class='index'>" + (index + 1) + "</td>";
					$.each(row,function (column,value){
						//alert(column + ' ' + value);
						if(index == 0){
							ths += "<th>" +  column + "</th>";	
						}
						trs += "<td>" + value + "</td>";
					});
					trs += "</tr>";
	          });
	          ths += "</tr>";
	          //alert(ths);
	          //alert(trs);
	          $("#div_result").empty();
	          $("#div_result").append("<table class='tb_list'>" + ths + trs + "</table>");
			}
		});
		
	</script>
    </footer>
  </body>
</html>
