(function(mui, window, document, undefined) {
	mui.init();
	var get = function(id) {
		return document.getElementById(id);
	};
	var qsa = function(sel) {
		return [].slice.call(document.querySelectorAll(sel));
	};
	
	 var appointmentTime= $("#appointmentTime").val();
	 var patientUserName= $("#patientUserName").val();
	 var patientUserMobile= $("#patientUserMobile").val();
	 var patientUserCardId= $("#patientUserCardId").val();
	 var patientUserAge= $("#patientUserAge").val();
	 var caseDetail= $("#caseDetail").val();
	 var patientUserSex= $("#patientUserSex").val();
	 
	var ui = {
		appointmentTime: get('appointmentTime'),
		patientUserName: get('patientUserName'),
		patientUserSex: get('patientUserSex'),
		patientUserMobile: get('patientUserMobile'),
		patientUserCardId: get('patientUserCardId'),
		patientUserAge: get('patientUserAge'),
		imageList: get('image-list'),
		submit: get('submit_id')
	};
	ui.clearForm = function() {
		ui.imageList.innerHTML = '';
		ui.appointmentTime.innerHTML = '';
		ui.patientUserName.innerHTML = '';
		ui.patientUserSex.innerHTML = '';
		ui.patientUserMobile.innerHTML = '';
		ui.patientUserCardId.innerHTML = '';
		ui.patientUserAge.innerHTML = '';
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
	ui.submit.addEventListener('tap', function(event){
		
		 if(ui.patientUserName.value==null || ui.patientUserName.value=='')
		 {
			 $.toast("姓名为空", "forbidden");
			 return;
		 }else if(ui.patientUserSex.value==null || ui.patientUserSex.value=='')
		 {
			 $.toast("请选择性别", "forbidden");
			 return;
		 }else if(ui.patientUserMobile.value==null || ui.patientUserMobile.value=='')
		 {
			 $.toast("手机号为空", "forbidden");
			 return;
		 }else if(ui.patientUserCardId.value==null || ui.patientUserCardId.value=='')
		 {
			 $.toast("身份证为空", "forbidden");
			 return;
		 }else if(ui.patientUserAge.value==null || ui.patientUserAge.value=='')
		 {
			 $.toast("年龄为空", "forbidden");
			 return;
		 }else if(ui.appointmentTime.value==null || ui.appointmentTime.value=='')
		 {
			 $.toast("预约时间为空", "forbidden");
			 return;
		 }else
		 {
			    $("#submit_id").hide();
			    var timestamp=(new Date()).getTime();
		  	    var url="http://m.shenglixiangjian.cn/healthService?action=saveAppointment&timestamp="+timestamp;
		  	    $.toast("提交成功");
		  	    document.form1.action=url;
		  	    document.form1.submit();
		  	  
		 }
		   
		
	}, false);
})(mui, window, document, undefined);
