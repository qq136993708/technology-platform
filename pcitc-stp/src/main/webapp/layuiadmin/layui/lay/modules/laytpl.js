/** layui-v2.3.0 MIT License By https://www.layui.com */ ;
layui.define(['jquery'],function (e) {
    "use strict";
    var $=layui.jquery;
    var r = {
            open: "{{",
            close: "}}"
        },
        c = {
            exp: function (e) {
                return new RegExp(e, "g")
            }, query: function (e, c, t) {
                var o = ["#([\\s\\S])+?", "([^{#}])*?"][e || 0];
                return n((c || "") + r.open + o + r.close + (t || ""))
            }, escape: function (e) {
                return String(e || "").replace(/&(?!#?[a-zA-Z0-9]+;)/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/'/g, "&#39;").replace(/"/g, "&quot;")
            }, error: function (e, r) {
                var c = "Laytpl Error：";
                return "object" == typeof console && console.error(c + e + "\n" + (r || "")), c + e
            }
        },
        n = c.exp,
        t = function (e) {
            this.tpl = e
        };
    t.pt = t.prototype, window.errors = 0, t.pt.parse = function (e, t) {
        var o = this,
            p = e,
            a = n("^" + r.open + "#", ""),
            l = n(r.close + "$", "");
        e = e.replace(/\s+|\r|\t|\n/g, " ").replace(n(r.open + "#"), r.open + "# ").replace(n(r.close + "}"), "} " + r.close).replace(/\\/g, "\\\\").replace(n(r.open + "!(.+?)!" + r.close), function (e) {
            return e = e.replace(n("^" + r.open + "!"), "").replace(n("!" + r.close), "").replace(n(r.open + "|" + r.close), function (e) {
                return e.replace(/(.)/g, "\\$1")
            })
        }).replace(/(?="|')/g, "\\").replace(c.query(), function (e) {
            return e = e.replace(a, "").replace(l, ""), '";' + e.replace(/\\/g, "") + ';view+="'
        }).replace(c.query(1), function (e) {
            var c = '"+(';
            return e.replace(/\s/g, "") === r.open + r.close ? "" : (e = e.replace(n(r.open + "|" + r.close), ""), /^=/.test(e) && (e = e.replace(/^=/, ""), c = '"+_escape_('), c + e.replace(/\\/g, "") + ')+"')
        }), e = '"use strict";var view = "' + e + '";return view;';
        try {
            return o.cache = e = new Function("d, _escape_", e), e(t, c.escape)
        } catch (u) {
            return delete o.cache, c.error(u, p)
        }
    }, t.pt.render = function (e, r) {
        var n, t = this;
        return e ? (n = t.cache ? t.cache(e, c.escape) : t.parse(t.tpl, e), r ? void r(n) : n) : c.error("no data")
    };
    var o = function (e) {
        return "string" != typeof e ? c.error("Template not found") : new t(e)
    };
    o.config = function (e) {
        e = e || {};
        for (var c in e) r[c] = e[c]
    }, o.v = "1.2.0", e("laytpl", o)
    o.toDateString = function(d, format){

    	if(d == null || d == '' || d == undefined){
            return "";
        }
        var date = new Date(d)
            ,ymd = [
            this.digit(date.getFullYear(), 4)
            ,this.digit(date.getMonth() + 1)
            ,this.digit(date.getDate())
        ]
            ,hms = [
            this.digit(date.getHours())
            ,this.digit(date.getMinutes())
            ,this.digit(date.getSeconds())
        ];

        format = format || 'yyyy-MM-dd HH:mm:ss';

        return format.replace(/yyyy/g, ymd[0])
            .replace(/MM/g, ymd[1])
            .replace(/dd/g, ymd[2])
            .replace(/HH/g, hms[0])
            .replace(/mm/g, hms[1])
            .replace(/ss/g, hms[2]);
    };

    //数字前置补零
    o.digit = function(num, length, end){
        var str = '';
        num = String(num);
        length = length || 2;
        for(var i = num.length; i < length; i++){
            str += '0';
        }
        return num < Math.pow(10, length) ? str + (num|0) : num;
    };
    o.state = function(d){
        var stateData;
        if(d==0){
            stateData="<span class='fontColor-red'>未审批</span>"
        }else if(d==1){
            stateData="<span class='fontColor-blue'>审批通过</span>"
        }else if(d==2){
            stateData="审批中"
        }else if(d==3){
            stateData="未通过"
        }
        return stateData;
    };
    /*o.auditStatus = function(d){
        var stateData;
        if(d==0){
            stateData="<span class='fontStateColor fontStateColor-yellow'></span>"
        }else if(d==1){
            stateData="<span class='fontStateColor fontStateColor-green'></span>"
        }else if(d==2){
            stateData="<span class='fontStateColor fontStateColor-blue'></span>"
        }
        return stateData;
    };*/
    o.auditStatus = function(d){
        var stateData;
        if(d==0){
            stateData="<span class='fontStateColor fontStateColor-yellow'></span>"
        }else if(d==1){
            stateData="<span class='fontStateColor fontStateColor-green'></span>"
        }else if(d==2){
            stateData="<span class='fontStateColor fontStateColor-blue'></span>"
        }
        return stateData;
    };
    
    o.auditStatus_equipment = function(d){
        var stateData;
        if(d==0){
            stateData="<span class='fontStateColor btnYellow'></span>"
        }else if(d==1){
            stateData="<span class='fontStateColor btn-green'></span>"
        }else if(d==2){
            stateData="<span class='fontStateColor btn-blue'></span>"
        }else if(d==3){
            stateData="<span class='fontStateColor btn-yellow'></span>"
        }
        return stateData;
    };
	
	o.purchaseState_equipment = function(d){
        var stateData;
         if(d!=0&&d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.taskStatus_equipment = function(d){
        var stateData;
         if(d!=0&&d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.contractSlosureState = function(d){
        var stateData;
        if(d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.installationState = function(d){
        var stateData;
        if(d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.contractAcceptanceState = function(d){
        var stateData;
        if(d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.arrivalReceiptState = function(d){
        var stateData;
        if(d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.contractDockingState = function(d){
        var stateData;
        if(d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.purchaseState = function(d){
        var stateData;
        if(d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.acceptanceStatus_equipment = function(d){
        var stateData;
        if(d!=0&&d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.forapplicationStatus_equipment = function(d){
        var stateData;    
		if(d>=20){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
             stateData="<span></span>"
        }
        return stateData;
    };
	
	o.fprappStatus_equipment = function(d){
        var stateData;
        if(d==10){
            stateData="<span class='fontStateColor btnYellow'></span>"
        }else if(d==20){
            stateData="<span class='fontStateColor btn-green'></span>"
        }else if(d==30){
            stateData="<span class='fontStateColor btn-blue'></span>"
        }else if(d==40){
            stateData="<span class='fontStateColor btn-yellow'></span>"
        }
        return stateData;
    };
	
	o.contractStatus_equipment = function(d){
        var stateData;
        if(d!=""&&d!=null){
			stateData="<span class='fontStateColor  btn-green'></span>"
        }else{
              stateData="<span></span>"
        }
        return stateData;
    };
    
    o.releaseStatus = function(d){
        var stateData;
        if(d==0){
            stateData="<span class='fontStateColor fontStateColor-yellow'></span>"
        }else if(d==1){
            stateData="<span class='fontStateColor fontStateColor-blue'></span>"
        }
        return stateData;
    };
    o.grantStatus = function(d){
        var stateData;
        if(d=='已保存'||d==0){
            stateData="<span class='fontStateColor fontStateColor-yellow'></span>"
        }else if(d=='已下发'||d==1){
            stateData="<span class='fontStateColor fontStateColor-blue'></span>"
        }
        return stateData;
    };
    o.contractorStatus = function(d){
        var stateData;
        if(d == 1){
            stateData="<img src='/layuiadmin/layui/images/icon_46.png'/>"
        }else if(d == 0){
            stateData="<img src='/layuiadmin/layui/images/icon_74.png'/>"
        }else{
        	stateData="<img src='/layuiadmin/layui/images/operation_71.png'/>"
        }
        return stateData;
    };
    o.state_purchase = function(d){
        var stateData;
        if(d==10){
            stateData="<span class='fontStateColor btnYellow'></span>"
        }else if(d==11){
            stateData="<span class='fontStateColor btn-green'></span>"
        }else if(d==20){
            stateData="<span class='fontStateColor btn-blue'></span>"
        }else if(d==13){
            stateData="<span class='fontStateColor btn-yellow'></span>"
        }else if(d>=20){
            stateData="<span class='fontStateColor btn-blue'></span>"
        }
        return stateData;
    };
    o.tableRowspan = function(d){
       var htmlData='';
       if(d.indexOf(",")!=-1){
           var dArr=d.split(',');
           $.each(dArr,function(i,dt){
               htmlData+="<p class='tableRowspanP'>"+dArr[i]+"</p>"
               //console.log(dArr[i])
           });
       }else {
           htmlData="<p class='tableRowspanP'>"+d+"</p>";
       }
       return htmlData;
    };
    o.attToPic = function(d){
        var htmlImg='';
        var value = d.attachment;
        var dataId = d.dataId;
        if(value>0){
            htmlImg= "<img src='/layuiadmin/layui/images/icon_20.png' style='cursor:pointer' class='onClickImg' id='"+d.dataId+"'/>";
        }else{
            htmlImg="";
        }
        return htmlImg;
    };
    o.search = function(d){
        var html='';
        /*var html=" <div class='layui-div'>" +
            "        <a href='#'>2018年直属研究院科研<em>预算</em></a>" +
            "        <div class='c-row c-gap-top-small'>" +
            "            <a href=''>" +
            "                <img src='/layuiadmin/layui/images/icon-seach-j.png' alt=''>" +
            "            </a>" +
            "            <div class='c-span18 c-span-last'>" +
            "                <p>2018年直属研究院科研<em>预算</em></p>" +
            "            </div>" +
            "        </div>" +
            "    </div>";*/
        var title='',abstract='';
        console.log(d)
        if(d.cgmc!=undefined){
            title=d.cgmc;
        }else if(d.xmmc!=undefined){
            title=d.xmmc;
        }else if(d.reportDesc!=undefined){
            title=d.reportDesc;
        }else if(d.extend03!=undefined){
            title=d.extend03;
        }else if(d.patentName!=undefined){
            title=d.patentName;
        }else if(d.expertName!=undefined){
            title=d.expertName;
        }else if(d.typeName!=undefined){
            title=d.typeName;
        }else if(d.fileName!=undefined){
            title=d.fileName;
        }
        if(d.userDesc){
            abstract=d.userDesc;
        }else if(d.patentDesc){
            abstract=d.patentDesc;
        }else if(d.typeScope){
            abstract=d.typeScope;
        }else if(d.sbdw){
            abstract=d.sbdw;
        }else if(d.reportDesc){
            abstract=d.reportDesc;
        }else if(d.define8){
            abstract=d.define8;
        }else if(d.cgmc){
            abstract=d.cgmc;
        }
        var select_type="";
        if(!d.select_type=="undefined"){
            var select_type="+"+d.select_type;
        }
        html='<div class="layui-div layui-div-n">' +
            '        <a href="#">'+title+'<span style="color: #1ea5bb"> '+select_type+'</span></a>' +
            '        <div class="c-row c-gap-top-small">' +
            '            <div class="c-span18 c-span-last">' +
            '                <p>'+abstract+'</p>' +
            '            </div>' +
            '        </div>' +
            '    </div>';
        return html;
    };
    o.searchE = function(d){
        var html=" <div class='layui-div'>" +
            "        <a class='openUrl'>"+d.name+"</a>" +
            "        <div class='c-row c-gap-top-small'>" +
            "            <a class='openUrl'>" +
            "                <img src='/layuiadmin/layui/images/icon-seach-j.png' alt=''>" +
            "            </a>" +
            "            <div class='c-span18 c-span-last'>" +
            "                <p>"+"</p>" +
            "            </div>" +
            "        </div>" +
            "    </div>";
        return html;
    };
    o.milliFormat = function (number, decimals, dec_point, thousands_sep,roundtag) {
        /*
        * 参数说明：
        * number：要格式化的数字
        * decimals：保留几位小数
        * dec_point：小数点符号
        * thousands_sep：千分位符号
        * roundtag:舍入参数，默认 "ceil" 向上取,"floor"向下取,"round" 四舍五入
        * */
        number = (number + '').replace(/[^0-9+-Ee.]/g, '');
        roundtag = roundtag || "ceil"; //"ceil","floor","round"
        var n = !isFinite(+number) ? 0 : +number,
            prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
            sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
            dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
            s = '',
            toFixedFix = function (n, prec) {
                var k = Math.pow(10, prec);
                console.log();
                return '' + parseFloat(Math[roundtag](parseFloat((n * k).toFixed(prec*2))).toFixed(prec*2)) / k;
            };
        s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
        var re = /(-?\d+)(\d{3})/;
        while (re.test(s[0])) {
            s[0] = s[0].replace(re, "$1" + sep + "$2");
        }
        if ((s[1] || '').length < prec) {
            s[1] = s[1] || '';
            s[1] += new Array(prec - s[1].length + 1).join('0');
        }
        return s.join(dec);
    }
});