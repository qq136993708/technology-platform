function getLen( str)
{
   var totallength=0;   
   for (var i=0;i<str.length;i++)
   {
	    var intCode=str.charCodeAt(i);    
	    if (intCode>=0&&intCode<=128) 
	    {
	       totallength=totallength+1; 
	    }
	    else 
	    {
	       totallength=totallength+2; 
	    }
   } 
 return totallength;
}




(function(mui, window, document, undefined) {
	mui.init();
	var get = function(id) {
		return document.getElementById(id);
	};
	var qsa = function(sel) {
		return [].slice.call(document.querySelectorAll(sel));
	};
	var ui = {
		question: get('content'),
		contact: get('contactWay'),
		imageList: get('image-list'),
		submit: get('submit')
	};
	ui.clearForm = function() {
		ui.question.value = '';
		ui.contact.value = '';
		ui.imageList.innerHTML = '';
		ui.newPlaceholder();
	};
	ui.getFileInputArray = function() {
		return [].slice.call(ui.imageList.querySelectorAll('input[type="file"]'));
	};
	ui.getFileInputIdArray = function() {
		var fileInputArray = ui.getFileInputArray();
		var idArray = [];
		fileInputArray.forEach(function(fileInput) {
			if (fileInput.value != '') {
				idArray.push(fileInput.getAttribute('id'));
			}
		});
		return idArray;
	};
	var imageIndexIdNum = 0;
	ui.newPlaceholder = function() {
		var fileInputArray = ui.getFileInputArray();
		if (fileInputArray &&
			fileInputArray.length > 0 &&
			fileInputArray[fileInputArray.length - 1].parentNode.classList.contains('space')) {
			return;
		}
		imageIndexIdNum++;
		var placeholder = document.createElement('div');
		placeholder.setAttribute('class', 'image-item space');
		var closeButton = document.createElement('div');
		closeButton.setAttribute('class', 'image-close');
		closeButton.innerHTML = 'X';
		closeButton.addEventListener('click', function(event) {
			event.stopPropagation();
			event.cancelBubble = true;
			setTimeout(function() {
				ui.imageList.removeChild(placeholder);
			}, 0);
			return false;
		}, false);
		var fileInput = document.createElement('input');
		fileInput.setAttribute('type', 'file');
		fileInput.setAttribute('name', 'myfiles');
		fileInput.setAttribute('accept', 'image/*');
		fileInput.setAttribute('id', 'image-' + imageIndexIdNum);
		fileInput.addEventListener('change', function(event) {
			var file = fileInput.files[0];
			if (file) {
				var reader = new FileReader();
				
				reader.onload = function() {
					//处理 android 4.1 兼容问题
					var base64 = reader.result.split(',')[1];
					var dataUrl = 'data:image/png;base64,' + base64;
					//alert(dataUrl);
					//alert(dataURLtoBlob(dataUrl));
					//
					placeholder.style.backgroundImage = 'url(' + dataUrl + ')';
				}
				reader.readAsDataURL(file);
				placeholder.classList.remove('space');
				ui.newPlaceholder();
			}
		}, false);
		placeholder.appendChild(closeButton);
		placeholder.appendChild(fileInput);
		ui.imageList.appendChild(placeholder);
	};
	ui.newPlaceholder();
	ui.submit.addEventListener('tap', function(event) {
		if (ui.question.value == '') 
		{
			return mui.toast('问题和意见不能为空');
		}else if (getLen(ui.question.value)>4000 ) 
		{
			return mui.toast('问题和意见内容不能超4000字符');
		}
		else if (ui.contact.value == '') 
		{
			return mui.toast('QQ/邮箱/手机不能为空');
		}else if (getLen(ui.contact.value)>50 ) 
		{
			return mui.toast('QQ/邮箱/手机不能超50字符');
		}
		else
			{
			   var timestamp=(new Date()).getTime();
		  	   var url="http://m.shenglixiangjian.cn/advice.do?action=saveAdvice&timestamp="+timestamp;
		  	   
		  	 mui.alert('提交成功', '提示', function() {
		  		 document.form1.action=url;
			  	   document.form1.submit();
				});
				
				
		  	  
		  	  
		  	  
		      
			}
		//plus.nativeUI.showWaiting();
		/*feedback.send({
			question: ui.question.value,
			contact: ui.contact.value,
			images: ui.getFileInputIdArray()
		}, function() {
			//plus.nativeUI.closeWaiting();
			mui.toast('感谢您的建议~');
			ui.clearForm();
			mui.back();
		});*/
	}, false);
})(mui, window, document, undefined);