/*
https://learning-collection.com/springboot-x-ajax%E9%80%9A%E4%BF%A1%E3%81%AB%E3%82%88%E3%82%8B%E7%94%BB%E9%9D%A2%E9%81%B7%E7%A7%BB/
*/

function clickGet(){	
	$.ajax({
		url:'/jq/confajax',
		type: 'GET',
		timeout: 6000,
		data: null
		
	})
		.done(function(){
			location.href="/jq/confajax";
		})
		.fail(function(){
			alert('faild');
		})
}