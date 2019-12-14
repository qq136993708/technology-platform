   autofont();
	function autofont(){
		var designWidth = 1920, rem2px = 100;
		var designHeight = 1080;
//		var windowWidth=(window.innerWidth>designWidth)?designWidth:window.innerWidth;
      var windowWidth=window.innerWidth;
      var windowHeight=window.innerHeight;
      var widthfont=((windowWidth / designWidth) * rem2px);
      var heightfont=((windowHeight / designHeight) * rem2px);
      if(parseFloat(widthfont)<parseFloat(heightfont)){
         document.documentElement.style.fontSize=parseFloat(widthfont)+'px';
      }else{
         document.documentElement.style.fontSize=parseFloat(heightfont)+'px';
      }
	}