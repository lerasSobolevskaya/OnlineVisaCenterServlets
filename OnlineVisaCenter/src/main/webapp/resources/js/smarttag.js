;(function(){var dfltPluginCfg={"sourceFile":"upload","info":"True"};var dfltGlobalCfg={"site":578005,"log":"logc407","logSSL":"logs1407","domain":"xiti.com","secure":false,"pixelPath":"/hit.xiti","disableCookie":false,"cookieSecure":false,"cookieDomain":"xiti.com","preview":false,"plgs":["ClientSideUserId","ContextVariables","Page"],"lazyLoadingPath":"","documentLevel":"document","redirect":false,"activateCallbacks":false,"medium":"","ignoreEmptyChapterValue":true};(function(a,b){a.ATInternet=a.ATInternet||{};a.ATInternet.Tracker=a.ATInternet.Tracker||{};a.ATInternet.Tracker.Plugins=a.ATInternet.Tracker.Plugins||{}})(window);
window.ATInternet.Utils=new function(){function a(b){var l=typeof b;if("object"!==l||null===b)return"string"===l&&(b='"'+b+'"'),String(b);var g,c,d=[],e=b&&b.constructor===Array;for(g in b)b.hasOwnProperty(g)&&(c=b[g],l=typeof c,"function"!==l&&"undefined"!==l&&("string"===l?c='"'+c.replace(/[^\\]"/g,'\\"')+'"':"object"===l&&null!==c&&(c=a(c)),d.push((e?"":'"'+g+'":')+String(c))));return(e?"[":"{")+String(d)+(e?"]":"}")}var b=this;b.cloneSimpleObject=function l(a,c){if("object"!==typeof a||null===
a||a instanceof Date)return a;var d=new a.constructor||a.constructor(),e;for(e in a)a.hasOwnProperty(e)&&(void 0===e||c&&void 0===a[e]||(d[e]=l(a[e])));return d};b.jsonSerialize=function(l){return"undefined"!==typeof JSON&&JSON.stringify?JSON.stringify(l):a(l)};b.jsonParse=function(a){try{if("undefined"!==typeof JSON&&JSON.parse)return JSON.parse(a);var b;b=null===a?a:"string"===typeof a?(new Function("return "+a))():!1;return b}catch(c){return null}};b.arrayIndexOf=function(a,b){return Array.indexOf?
a.indexOf(b):function(a){if(null==this)throw new TypeError;var d=Object(this),e=d.length>>>0;if(0===e)return-1;var k=0;1<arguments.length&&(k=Number(arguments[1]),k!=k?k=0:0!=k&&Infinity!=k&&-Infinity!=k&&(k=(0<k||-1)*Math.floor(Math.abs(k))));if(k>=e)return-1;for(k=0<=k?k:Math.max(e-Math.abs(k),0);k<e;k++)if(k in d&&d[k]===a)return k;return-1}.apply(a,[b])};b.genGuid=function(a){var b=new Date,c=function(a){a-=100*Math.floor(a/100);return 10>a?"0"+a:a};return c(b.getHours())+""+c(b.getMinutes())+
""+c(b.getSeconds())+""+function(a){return Math.floor(Math.random()*Math.pow(10,a))}(a-6)};b.getObjectKeys=function(a){var b=[],c;for(c in a)a.hasOwnProperty(c)&&b.push(c);return b};b.completeFstLevelObj=function(a,b,c){if(a){if(b)for(var d in b)!b.hasOwnProperty(d)||a[d]&&!c||(a[d]=b[d])}else a=b;return a};b.isPreview=function(){return window.navigator&&"preview"===window.navigator.loadPurpose};b.isPrerender=function(a){var g,c=!1,d=["webkit","ms"];if("prerender"===document.visibilityState)g="visibilitychange";
else for(var e=0;e<d.length;e++)"prerender"===document[d[e]+"VisibilityState"]&&(g=d[e]+"visibilitychange");if("undefined"!==typeof g){var k=function(e){a(e);b.removeEvtListener(document,g,k)};b.addEvtListener(document,g,k);c=!0}return c};var h=b.addEvtListener=function(a,b,c){a.addEventListener?a.addEventListener(b,c,!1):a.attachEvent&&a.attachEvent("on"+b,c)};b.removeEvtListener=function(a,b,c){a.removeEventListener?a.removeEventListener(b,c,!1):a.detachEvent&&a.detachEvent("on"+b,c)};b.loadScript=
function(a,b){var c;b=b||function(){};c=document.createElement("script");c.type="text/javascript";c.src=a.url;c.async=!1;c.defer=!1;c.onload=c.onreadystatechange=function(a){a=a||window.event;if("load"===a.type||/loaded|complete/.test(c.readyState)&&(!document.documentMode||9>document.documentMode))c.onload=c.onreadystatechange=c.onerror=null,b(null,a)};c.onerror=function(a,d,l){c.onload=c.onreadystatechange=c.onerror=null;b({msg:"script not loaded",event:a})};var d=document.head||document.getElementsByTagName("head")[0];
d.insertBefore(c,d.lastChild)};b.hashcode=function(a){var b=0;if(0===a.length)return b;for(var c=0;c<a.length;c++)var d=a.charCodeAt(c),b=(b<<5)-b+d,b=b&b;return b};b.setLocation=function(a){var b=a.location;a=window[a.target]||window;b&&(a.location.href=b)};b.dispatchCallbackEvent=function(a){var b=document.createEvent("Event");b.initEvent("ATCallbackEvent",!0,!0);b.name=a;document.dispatchEvent(b)};b.addCallbackEvent=function(a){document.createEvent("Event").initEvent("ATCallbackEvent",!0,!0);h(document,
"ATCallbackEvent",a)}};
var BuildManager=function(a){var b=this,h=function(a,d,b){a="&"+a+"=";return{param:a,paramSize:a.length,str:d,strSize:d.length,truncate:b}},f=function(e,d){var b="",c=0,l=!0,f;for(f in e)if(e.hasOwnProperty(f)){var g=e[f];if(g){var l=!1,h=d-c;if(g.strSize+g.paramSize<h)b+=g.param+g.str,c+=g.strSize+g.paramSize,e[f]=void 0,l=!0;else{g.truncate?(b+=g.param+g.str.substr(0,h),e[f].str=g.str.substr(h,g.strSize-1),e[f].strSize=e[f].str.length):g.strSize+g.paramSize>d&&(a.emit("Tracker:Hit:Build:Error",{lvl:"ERROR",
msg:'Too long parameter "'+g.param+'"',details:{value:g.str}}),e[f].str=e[f].str.substr(0,d-g.paramSize-1),e[f].strSize=e[f].str.length);break}}else l=!0}return[b,l?null:e]},l=["ati","atc","pdtl","stc","dz"],g=function(d,b,c){var g=function(a){if(a==={})return"";var b=[],d;d={};var e=0,c=!1,k=void 0,g,p,n;for(n in a)if(a.hasOwnProperty(n)){var r=a[n].value;"function"===typeof r&&(r=r());r=r instanceof Array?r.join(a[n].options.separator||","):"object"===typeof r?window.ATInternet.Utils.jsonSerialize(r):
"undefined"===typeof r?"undefined":r.toString();a[n].options.encode&&(r=encodeURIComponent(r));var q=h(n,r,-1<window.ATInternet.Utils.arrayIndexOf(l,n)),e=e+(q.paramSize+q.strSize);if(a[n].options.last)1490<r.length&&r.substr(0,1490),g=n,p=q;else if(d[n]=q,1500<d[n].paramSize+d[n].strSize&&!d[n].truncate){c=!0;k=n;break}}g&&(d[g]=p);d=[d,e,c,k];a=d[0];if(d[2])d=d[3],a=a[d],a.str=a.str.substr(0,1450),a.strSize=1450,e={},e.mherr=h("mherr","1",!1),e[d]=a,b.push(f(e,1500)[0]);else if(d=f(a,1500),null===
d[1])b=d[0];else for(b.push(d[0]);null!==d[1];)d=f(a,1500),b.push(d[0]);return b},p="";a.buffer.presentInFilters(b,"hitType")||(b=a.buffer.addInFilters(b,"hitType",["page"]));b=a.buffer.addInFilters(b,"hitType",["all"]);var r;if(d){b=a.buffer.addInFilters(b,"permanent",!0);b=a.buffer.get(b,!0);for(r in d)d.hasOwnProperty(r)&&(b[r]={value:d[r],options:{}});p=g(b)}else for(r in b=a.buffer.get(b,!0),p=g(b),b)b.hasOwnProperty(r)&&!b[r].options.permanent&&a.buffer.del(r);c&&c(p)},c=function(d){var b=a.getConfig("secure"),
c="https:"===document.location.protocol,c=b||c?a.getConfig("logSSL"):a.getConfig("log"),f=a.getConfig("baseURL"),l=a.getConfig("domain"),g=a.getConfig("pixelPath"),h=a.getConfig("site");(f||c&&l&&g)&&h?d&&d(null,(f?f:(b?"https://":"//")+c+("."+l)+g)+("?s="+h)):d&&d({message:"Config error"})},d=function(a,d,b){c(function(c,f){c?b&&b(c):g(a,d,function(a){var d=[],c=window.ATInternet.Utils.genGuid(13);if(a instanceof Array)if(1===a.length)d.push(f+"&mh=1-2-"+c+a[0]);else for(var e=1;e<=a.length;e++)d.push(f+
"&mh="+e+"-"+a.length+"-"+c+a[e-1]);else d.push(f+a);b&&b(null,d)})})};b.send=function(c,k){d(c,k,function(d,c){if(d)a.emit("Tracker:Hit:Build:Error",{lvl:"ERROR",msg:d.message,details:{hits:c}});else for(var e=0;e<c.length;e++)b.sendUrl(c[e])})};b.sendUrl=function(d){var b=function(d,b){return function(){return function(c){a.emit(d,{lvl:-1===d.indexOf("Error")?"INFO":"ERROR",details:{hit:b,event:c}})}}()},c=new Image;c.onload=b("Tracker:Hit:Sent:Ok",d);c.onerror=b("Tracker:Hit:Sent:Error",d);c.src=
d}},TriggersManager=function(){function a(a,b,c){for(var d=[],e=0;e<a.length;e++)a[e].callback(b,c),a[e].singleUse||d.push(a[e]);return d}function b(a,f,c,d){var e=a.shift();if("*"===e)return f["*"]=f["*"]||[],f["*"].push({callback:c,singleUse:d}),f["*"].length-1;if(0===a.length)return b([e,"*"],f,c,d);f["*"]=f["*"]||[];f[e]=f[e]||{};return b(a,f[e],c,d)}function h(b,f,c,d){var e=f.shift();"*"!==e&&(0===f.length?h(b,[e,"*"],c,d):c[e]&&(c[e]["*"]=a(c[e]["*"],b,d),h(b,f,c[e],d)))}var f={};this.on=function(a,
g,c){c=c||!1;return b(a.split(":"),f,g,c)};this.emit=function(b,g){f["*"]&&(f["*"]=a(f["*"],b,g));h(b,b.split(":"),f,g)}},PluginsManager=function(a){var b={},h={},f=0,l={},g=0,c=this.load=function(c,e){"function"===typeof e?"undefined"===typeof a.getConfig.plgAllowed||0===a.getConfig.plgAllowed.length||-1<a.getConfig.plgAllowed.indexOf(c)?(b[c]=new e(a),h[c]&&b[c]&&(h[c]=!1,f--,b[c+"_ll"]&&d(c+"_ll"),0===f&&a.emit("Tracker:Plugin:Lazyload:File:Complete",{lvl:"INFO",msg:"LazyLoading triggers are finished"})),
a.emit("Tracker:Plugin:Load:"+c+":Ok",{lvl:"INFO"})):a.emit("Tracker:Plugin:Load:"+c+":Error",{lvl:"ERROR",msg:"Plugin not allowed",details:{}}):a.emit("Tracker:Plugin:Load:"+c+":Error",{lvl:"ERROR",msg:"not a function",details:{obj:e}});return a},d=this.unload=function(d){b[d]?(b[d]=void 0,a.emit("Tracker:Plugin:Unload:"+d+":Ok",{lvl:"INFO"})):a.emit("Tracker:Plugin:Unload:"+d+":Error",{lvl:"ERROR",msg:"not a known plugin"});return a},e=this.isLazyloading=function(a){return a?!0===h[a]:0!==f},k=
function(a){return q(a)?(n(a),!0):!1},n=function(d){h[d]=!0;f++;ATInternet.Utils.loadScript({url:a.getConfig("lazyLoadingPath")+d+".js"})},q=function(a){return!b[a]&&!e(a)&&(b[a+"_ll"]?!0:!1)},p=function(a){l[a]?l[a]++:l[a]=1;g++};this.isExecWaitingLazyloading=function(){return 0!==g};a.exec=this.exec=function(d,c,f,k){var h=null,t=function(a,d,c,e){d=d.split(".");b[a]&&b[a][d[0]]&&(h=1<d.length&&b[a][d[0]][d[1]]?b[a][d[0]][d[1]].apply(b[a],c):b[a][d[0]].apply(b[a],c));e&&e(h)},u=function(d,b,c,e){p(d);
a.onTrigger("Tracker:Plugin:Load:"+d+":Ok",function(){t(d,b,c,function(b){l[d]--;g--;0===g&&a.emit("Tracker:Plugin:Lazyload:Exec:Complete",{lvl:"INFO",msg:"All exec waiting for lazyloading are done"});e&&e(b)})},!0)};q(d)?(u(d,c,f,k),n(d)):e(d)?u(d,c,f,k):t(d,c,f,k)};this.waitForDependencies=function(d,c){var e=function(a){for(var d={mcount:0,plugins:{}},c=0;c<a.length;c++)b.hasOwnProperty(a[c])||(d.mcount++,d.plugins[a[c]]=!0);return d}(d);if(0===e.mcount)a.emit("Tracker:Plugin:Dependencies:Loaded",
{lvl:"INFO",details:{dependencies:d}}),c();else for(var f in e.plugins)e.plugins.hasOwnProperty(f)&&(a.emit("Tracker:Plugin:Dependencies:Error",{lvl:"WARNING",msg:"Missing plugin "+f}),a.onTrigger("Tracker:Plugin:Load:"+f,function(a,d){var b=a.split(":"),f=b[3];"Ok"===b[4]&&(e.plugins[f]=!1,e.mcount--,0===e.mcount&&c())},!0),k(f))};this.init=function(){for(var a in ATInternet.Tracker.pluginProtos)ATInternet.Tracker.pluginProtos.hasOwnProperty(a)&&c(a,ATInternet.Tracker.pluginProtos[a])}},CallbacksManager=
function(a){var b={};this.init=function(){if(a.getConfig("activateCallbacks")){var f=a.getConfig("callbacks");(function(){if("undefined"!==typeof f&&f.include instanceof Array)for(var a=0;a<f.include.length;a++)ATInternet.Callbacks&&ATInternet.Callbacks.hasOwnProperty(f.include[a])&&(b[f.include[a]]={"function":ATInternet.Callbacks[f.include[a]]},ATInternet.Tracker.callbackProtos[f.include[a]]||(ATInternet.Tracker.callbackProtos[f.include[a]]=b[f.include[a]]));else for(a in ATInternet.Callbacks)ATInternet.Callbacks.hasOwnProperty(a)&&
(b[a]={"function":ATInternet.Callbacks[a]},ATInternet.Tracker.callbackProtos[a]||(ATInternet.Tracker.callbackProtos[a]=b[a]));if("undefined"!==typeof f&&f.exclude instanceof Array)for(a=0;a<f.exclude.length;a++)b[f.exclude[a]]&&(b[f.exclude[a]]=void 0);for(var g in b)b.hasOwnProperty(g)&&b[g]&&h(g,b[g]["function"])})();ATInternet.Utils.addCallbackEvent(function(a){if(a.name){var b=!0;"undefined"!==typeof f&&(f.include instanceof Array&&-1===ATInternet.Utils.arrayIndexOf(f.include,a.name)&&(b=!1),
f.exclude instanceof Array&&-1!==ATInternet.Utils.arrayIndexOf(f.exclude,a.name)&&(b=!1));if(ATInternet.Callbacks&&ATInternet.Callbacks.hasOwnProperty(a.name)){var c={};c[a.name]={"function":ATInternet.Callbacks[a.name]};b&&h(a.name,c[a.name]["function"]);ATInternet.Tracker.callbackProtos[a.name]||(ATInternet.Tracker.callbackProtos[a.name]=c[a.name])}}})}};var h=this.load=function(b,l){"function"===typeof l?(new l(a),a.emit("Tracker:Callback:Load:"+b+":Ok",{lvl:"INFO",details:{obj:l}})):a.emit("Tracker:Callback:Load:"+
b+":Error",{lvl:"ERROR",msg:"not a function",details:{obj:l}});return a}},BufferManager=function(a){var b={};this.set=function(a,f,c){c=c||{};c.hitType=c.hitType||["page"];b[a]={value:f,options:c}};var h=function(a,b,c){return(a=window.ATInternet.Utils.cloneSimpleObject(a[b]))&&!c?a.value:a},f=function g(a,d){if(!(a&&d instanceof Array&&a instanceof Array))return[];if(0===a.length)return d;var e=a[0],f,h=[],q=window.ATInternet.Utils.cloneSimpleObject(a);q.shift();for(var p=0;p<d.length;p++)if("object"!==
typeof e[1])b[d[p]]&&b[d[p]].options[e[0]]===e[1]&&h.push(d[p]);else{f=e[1].length;for(var r=0;r<f;r++)if(b[d[p]]&&b[d[p]].options[e[0]]instanceof Array&&0<=window.ATInternet.Utils.arrayIndexOf(b[d[p]].options[e[0]],e[1][r])){h.push(d[p]);break}}return g(q,h)};this.get=function(a,c){var d={};if("string"===typeof a)d=h(b,a,c);else for(var e=f(a,window.ATInternet.Utils.getObjectKeys(b)),k=0;k<e.length;k++)d[e[k]]=h(b,e[k],c);return d};this.presentInFilters=function c(a,b){return a&&0!==a.length?a[0][0]===
b?!0:c(a.slice(1),b):!1};this.addInFilters=function d(a,b,f,h){if(!a||0===a.length)return h?[]:[[b,f]];var p=a[0][0],r=a[0][1];p===b&&(r instanceof Array&&!(-1<window.ATInternet.Utils.arrayIndexOf(r,f[0]))&&r.push(f[0]),h=!0);return[[p,r]].concat(d(a.slice(1),b,f,h))};this.del=function(a){b[a]=void 0};this.clear=function(){b={}}},Tag=function(a,b,h){b=b||{};var f=this;f.version="5.5.0";var l=window.ATInternet.Utils.cloneSimpleObject(b);f.triggers=new TriggersManager(f);f.emit=f.triggers.emit;f.onTrigger=
f.triggers.on;var g=window.ATInternet.Utils.cloneSimpleObject(dfltGlobalCfg)||{},c;for(c in a)a.hasOwnProperty(c)&&(g[c]=a[c]);f.getConfig=function(a){return g[a]};f.setConfig=function(a,b,c){void 0!==g[a]&&c||(f.emit("Tracker:Config:Set:"+a,{lvl:"INFO",details:{bef:g[a],aft:b}}),g[a]=b)};f.configPlugin=function(a,b,c){g[a]=g[a]||{};for(var h in b)b.hasOwnProperty(h)&&void 0===g[a][h]&&(g[a][h]=b[h]);c&&(c(g[a]),f.onTrigger("Tracker:Config:Set:"+a,function(a,b){c(b.details.aft)}));return g[a]};f.getContext=
function(a){return l[a]};f.setContext=function(a,b){f.emit("Tracker:Context:Set:"+a,{lvl:"INFO",details:{bef:l[a],aft:b}});l[a]=b};f.delContext=function(a,b){f.emit("Tracker:Context:Deleted:"+a+":"+b,{lvl:"INFO",details:{key1:a,key2:b}});if(a)l.hasOwnProperty(a)&&(b?l[a]&&l[a].hasOwnProperty(b)&&(l[a][b]=void 0):l[a]=void 0);else if(b)for(var c in l)l.hasOwnProperty(c)&&l[c]&&l[c].hasOwnProperty(b)&&(l[c][b]=void 0)};f.plugins=new PluginsManager(f);f.buffer=new BufferManager(f);f.setParam=f.buffer.set;
f.getParams=function(a){return f.buffer.get(a,!1)};f.getParam=f.buffer.get;f.delParam=f.buffer.del;f.builder=new BuildManager(f);f.sendHit=f.builder.send;f.sendUrl=f.builder.sendUrl;f.callbacks=new CallbacksManager(f);f.setParam("ts",function(){return(new Date).getTime()},{permanent:!0,hitType:["all"]});f.getConfig("disableCookie")&&f.setParam("idclient","xxxxxx-NO",{permanent:!0,hitType:["all"]});f.getConfig("medium")&&f.setParam("medium",f.getConfig("medium"),{permanent:!0,hitType:["all"]});f.plugins.init();
f.callbacks.init();ATInternet.Tracker.instances.push(f);f.emit("Tracker:Ready",{lvl:"INFO",msg:"Tracker initialized",details:{tracker:f,args:{config:a,context:b,callback:h}}});h&&h(f)};ATInternet.Tracker.Tag=Tag;ATInternet.Tracker.instances=[];ATInternet.Tracker.pluginProtos={};
ATInternet.Tracker.addPlugin=function(a,b){b=b||ATInternet.Tracker.Plugins[a];if(!ATInternet.Tracker.pluginProtos[a]){ATInternet.Tracker.pluginProtos[a]=b;for(var h=0;h<ATInternet.Tracker.instances.length;h++)ATInternet.Tracker.instances[h].plugins.load(a,b)}};ATInternet.Tracker.delPlugin=function(a){if(ATInternet.Tracker.pluginProtos[a]){ATInternet.Tracker.pluginProtos[a]=void 0;for(var b=0;b<ATInternet.Tracker.instances.length;b++)ATInternet.Tracker.instances[b].plugins.unload(a)}};
ATInternet.Tracker.callbackProtos={};
}).call(window);;(function(){var dfltPluginCfg={"clientSideMode":"required","userIdCookieDuration":397,"userIdExpirationMode":"fixed","info":"True"};var dfltGlobalCfg={};window.ATInternet.Tracker.Plugins.ClientSideUserId=function(a){var b={},h=void 0,f=null;a.configPlugin("ClientSideUserId",dfltPluginCfg||{},function(a){b=a});var l=function(){h=a.getContext("userIdentifier");a.exec("Cookies","get",["atuserid"],function(a){f=a})},g=function(b,d){a.setParam("idclient",b,{permanent:!0,hitType:["all"]});c(b,d)},c=function(c,d){if("relative"===b.userIdExpirationMode||"fixed"===b.userIdExpirationMode&&null===f){var g=new Date;g.setTime(g.getTime()+864E5*b.userIdCookieDuration);
a.exec("Cookies","set",["atuserid",c,{end:g,path:"/"}]);a.exec("Cookies","get",["atuserid",!0],function(b){d||c===b||a.setParam("idclient",c+"-NO",{permanent:!0,hitType:["all"]})})}},d=function(){var a=!1;if("required"===b.clientSideMode){var c=navigator.userAgent;if(/Safari/.test(c)&&!/Chrome/.test(c)||/iPhone|iPod|iPad/.test(c))a=!0}else"always"===b.clientSideMode&&(a=!0);return a};a.plugins.waitForDependencies(["Cookies"],function(){l();var c="";if(d()){var k=!1;"undefined"!==typeof h?(c=h,k=!0):
c=null!==f?f:ATInternet.Utils.genGuid(13);g(c,k)}a.emit("ClientSideUserId:Ready",{lvl:"INFO",details:{clientSideMode:b.clientSideMode,userIdFromContext:h,userIdFromCookie:f,userId:c}})});a.clientSideUserId={};a.clientSideUserId.set=function(a){d()&&g(a,!0)}};window.ATInternet.Tracker.addPlugin("ClientSideUserId");
}).call(window);;(function(){var dfltPluginCfg={"domainAttribution":true,"info":"True"};var dfltGlobalCfg={"redirectionLifetime":30};window.ATInternet.Tracker.Plugins.ContextVariables=function(a){var b="",h=null,f="",l="",g={};a.configPlugin("ContextVariables",dfltPluginCfg||{},function(a){g=a});a.setConfig("redirectionLifetime",dfltGlobalCfg.redirectionLifetime,!0);var c=function(b,c,d){var e=null;a.plugins.exec(b,c,d,function(a){e=a});return e},d=function(a,b){return c("Utils",a,b)},e=function(b,c){var d=null;a.plugins.exec("Cookies",b,c,function(a){d=a});return d},k=function(){a.setParam("hl",function(){var a=new Date;return a.getHours()+
"x"+a.getMinutes()+"x"+a.getSeconds()},{permanent:!0,hitType:["all"]})},n=function(a){var c="",c="acc_dir"===b?"":b?b:"acc_dir"===h?"":h?h:a.referrer;return c.replace(/[<>]/g,"").substring(0,1600).replace(/&/g,"$")};a.plugins.waitForDependencies(["Cookies","Utils"],function(){f="set"+(g.domainAttribution?"":"Private");l="get"+(g.domainAttribution?"":"Private");var c=d("getLocation",[]);b=d("getQueryStringValue",["xtref",c]);if(a.getConfig("redirect")){var c=d("getDocumentLevel",[]),c=b||c.referrer||
"acc_dir",p;if(p=c){p={path:"/",end:a.getConfig("redirectionLifetime")};var r=e(l,[["atredir"]]);null!==r?p=!("object"!==typeof r||r instanceof Array):(e(f,["atredir",{},p]),p=!0)}p&&e(f,[["atredir","ref"],c])}else{h=e(l,[["atredir","ref"]]);e("del",[["atredir","ref"]]);a.setParam("vtag",a.version,{permanent:!0,hitType:["all"]});a.setParam("ptag","js",{permanent:!0,hitType:["all"]});c="";try{c+=window.screen.width+"x"+window.screen.height+"x"+window.screen.pixelDepth+"x"+window.screen.colorDepth}catch(s){}a.setParam("r",
c,{permanent:!0,hitType:["all"]});c="";window.innerWidth?c+=window.innerWidth+"x"+window.innerHeight:document.body.offsetWidth&&(c+=document.body.offsetWidth+"x"+document.body.offsetHeight);a.setParam("re",c,{permanent:!0,hitType:["all"]});k();a.setParam("lng",navigator.language||navigator.userLanguage,{permanent:!0,hitType:["all"]});c=window.ATInternet.Utils.genGuid(13);a.setParam("idp",c,{permanent:!0,hitType:["page","clickzone"]});a.setParam("jv",navigator.javaEnabled()?"1":"0",{hitType:["page"]});
c=d("getDocumentLevel",[]);a.setParam("ref",n(c),{permanent:!0,last:!0,hitType:["page"]})}a.emit("ContextVariables:Ready",{lvl:"INFO"})})};window.ATInternet.Tracker.addPlugin("ContextVariables");
}).call(window);;(function(){var dfltPluginCfg={"info":"False"};var dfltGlobalCfg={};window.ATInternet.Tracker.Plugins.Cookies=function(a){var b={},h=this.getCookie=function(b){return!a.getConfig("disableCookie")&&b&&"string"===typeof b&&(b=RegExp("(?:^| )"+b+"=([^;]+)").exec(document.cookie)||null)?decodeURIComponent(b[1]):null},f=this.setCookie=function(b,c,d){if(!a.getConfig("disableCookie")&&b&&"string"===typeof b&&"string"===typeof c){var e=a.getConfig("cookieDomain");b=b+"="+encodeURIComponent(c);c=!1;if(d){c=d.secure;var f=d.end,k=d.domain;d=d.path;b+=f?"function"===typeof f.toGMTString?
";expires="+f.toGMTString():"number"===typeof f?";max-age="+f.toString():"":"";b=b+(e||k?";domain="+(k?k:e):"")+(d&&"string"===typeof d?";path="+d:"")}e=a.getConfig("cookieSecure")||c;b+=e&&"boolean"===typeof e?";secure":"";document.cookie=b;return!0}return null},l=function(a){var b=null;(a=h(a))&&(b=ATInternet.Utils.jsonParse(a));return b},g=function(a){return f(a.name,ATInternet.Utils.jsonSerialize(a),a.options)?a:null},c=function(a,c,d){var e=null;if(!d&&b[a])e=b[a];else if(e=l(a))e.options.session&&
g(e),b[a]=e;return e?c?(a=null,!e||"object"!==typeof e.val||e.val instanceof Array||void 0===e.val[c]||(a=e.val[c]),a):e.val:null},d=function(a,c,d,e){var f=null;if(c){if(f=l(a))e=f,!e||"object"!==typeof e.val||e.val instanceof Array?f=null:(e.val[c]=d,f=e),f&&(f=g(f))}else c=e=e||{},e={},e.name=a,e.val=d,c.session&&"number"===typeof c.session&&(c.end=c.session),e.options=c,f=g(e);f&&(b[a]=f);return f?f.val:null},e=function(a,c){c?d(a,c,void 0):(b[a]=void 0,f(a,"",{end:0}))},k=this.get=function(a,
b){b=b||!1;return a instanceof Array&&2===a.length?c(a[0],a[1],b):c(a,void 0,b)};this.getPrivate=function(b,c){c=c||!1;b instanceof Array?b[0]+=a.getConfig("site"):b+=a.getConfig("site");return k(b,c)};var n=this.set=function(a,b,c){return a instanceof Array?d(a[0],a[1],b):d(a,null,b,c)};this.setPrivate=function(b,c,d){b instanceof Array?b[0]+=a.getConfig("site"):b+=a.getConfig("site");return n(b,c,d)};var q=this.del=function(a){return a instanceof Array?e(a[0],a[1]):e(a)};this.delPrivate=function(b){b instanceof
Array?b[0]+=a.getConfig("site"):b+=a.getConfig("site");return q(b)};this.cacheInvalidation=function(){b={}}};window.ATInternet.Tracker.addPlugin("Cookies");
}).call(window);;(function(){var dfltPluginCfg={"info":"True"};var dfltGlobalCfg={};window.ATInternet.Tracker.Plugins.Page=function(a){var b=["pageId","chapterLabel","update"],h=["pid","pchap","pidt"],f=["page","site"],l=["f","x"],g=function(b){var c=b.name;a.exec("Utils","manageChapters",[b,"chapter",3],function(a){c=a+(c?c:"")});return c},c=function(a,b,c){b?a=b:a||"undefined"===typeof c||(a=c);return a},d=function(a,b,d){b.hasOwnProperty(d)&&(a[d]=c(a[d],b[d]))},e=function(b){if(!ATInternet.Utils.isPreview()||a.getConfig("preview"))ATInternet.Utils.isPrerender(function(a){b(a)})||
b()},k=function(b,c,d){if(c)for(var e=0;e<f.length;e++)if(c.hasOwnProperty(f[e])&&c[f[e]])for(var k in c[f[e]])c[f[e]].hasOwnProperty(k)&&(d?b[l[e]+k]=c[f[e]][k]:a.setParam(l[e]+k,c[f[e]][k]))},n=function(c,d,e){if(d){a.exec("Utils","manageChapters",[d,"chapter",3],function(a){a&&(d.chapterLabel=a.replace(/::$/gi,""))});for(var f=0;f<h.length;f++)d.hasOwnProperty(b[f])&&(e?c[h[f]]=d[b[f]]:a.setParam(h[f],d[b[f]]))}},q=function(b,c,d){if(c&&c.keywords instanceof Array){var e=c.keywords.length;if(0<
e){for(var f="",k=0;k<e;k++)f+="["+c.keywords[k]+"]"+(k<e-1?"|":"");d?b.tag=f:a.setParam("tag",f)}}},p=function(b,c,d){if(c){var e,f=function(a){return a?a:"0"};e=""+(f(c.category1)+"-");e+=f(c.category2)+"-";e+=f(c.category3);d?b.ptype=e:a.setParam("ptype",e)}},r=function(b,c,d){if(c)for(var e in c)c.hasOwnProperty(e)&&"undefined"!==typeof c[e]&&(d?b[e]=c[e]:a.setParam(e,c[e]))};a.customVars=this.customVars={};a.customVars.set=this.customVars.set=function(b){var c=a.getContext("page")||{},d=c.customVars;
if(d){if(b)for(var e in b)b.hasOwnProperty(e)&&(d[e]=ATInternet.Utils.completeFstLevelObj(d[e],b[e],!0))}else d=b;c.customVars=d;a.setContext("page",c)};a.dynamicLabel=this.dynamicLabel={};a.dynamicLabel.set=this.dynamicLabel.set=function(b){var c=a.getContext("page")||{};c.dynamicLabel=ATInternet.Utils.completeFstLevelObj(c.dynamicLabel,b,!0);a.setContext("page",c)};a.tags=this.tags={};a.tags.set=this.tags.set=function(b){var c=a.getContext("page")||{};c.tags=ATInternet.Utils.completeFstLevelObj(c.tags,
b,!0);a.setContext("page",c)};a.customTreeStructure=this.customTreeStructure={};a.customTreeStructure.set=this.customTreeStructure.set=function(b){var c=a.getContext("page")||{};c.customTreeStructure=ATInternet.Utils.completeFstLevelObj(c.customTreeStructure,b,!0);a.setContext("page",c)};a.page={};a.page.reset=this.reset=function(){a.setContext("page",void 0)};a.page.set=this.set=function(b){a.dispatchSubscribe("page");var e=a.getContext("page")||{};e.name=c(e.name,b.name,"");e.level2=c(e.level2,
b.level2,"");d(e,b,"chapter1");d(e,b,"chapter2");d(e,b,"chapter3");e.customObject=ATInternet.Utils.completeFstLevelObj(e.customObject,b.customObject,!0);a.setContext("page",e)};a.page.send=this.send=function(b){var f={p:g(b),s2:b.level2||""},h=!0,l=b.customObject;if(l){var t=a.getParam("stc",!0);if(t&&t.options.permanent){var u=t?t.options.hitType:[],C=ATInternet.Utils.arrayIndexOf;if(-1!=C(u,"page")||-1!=C(u,"all"))l=ATInternet.Utils.completeFstLevelObj(t.value||{},l,!0)}a.exec("Utils","customObjectToString",
[l],function(a){f.stc=a})}l=a.getContext("page")||{};l.vrn&&(f.vrn=l.vrn,l.vrn=void 0,a.setContext("page",l));t=a.getContext("InternalSearch")||{};"undefined"!=typeof t.keyword&&(f.mc=ATInternet.Utils.cloneSimpleObject(t.keyword),"undefined"!=typeof t.resultPageNumber&&(f.np=ATInternet.Utils.cloneSimpleObject(t.resultPageNumber)),a.setContext("InternalSearch",void 0));ATInternet.Utils.isPreview()&&a.getConfig("preview")&&(f.pvw=1);k(f,b.customVars,!0);n(f,b.dynamicLabel,!0);q(f,b.tags,!0);p(f,b.customTreeStructure,
!0);t=a.getContext("campaigns")||{};r(f,t,!0);a.setContext("campaigns",void 0);a.exec("TechClicks","manageClick",[b.elem],function(a){h=a});e(function(){a.sendHit(f)});l.name=c(l.name,b.name,"");l.level2=c(l.level2,b.level2,"");d(l,b,"chapter1");d(l,b,"chapter2");d(l,b,"chapter3");a.setContext("page",l);return h};a.page.onDispatch=this.onDispatch=function(){var b=a.getContext("page")||{},c=a.getContext("InternalSearch")||{};a.setParam("p",g(b));a.setParam("s2",b.level2||"");b.vrn&&(a.setParam("vrn",
b.vrn),b.vrn=void 0,a.setContext("page",b));"undefined"!=typeof c.keyword&&(a.setParam("mc",ATInternet.Utils.cloneSimpleObject(c.keyword)),"undefined"!=typeof c.resultPageNumber&&a.setParam("np",ATInternet.Utils.cloneSimpleObject(c.resultPageNumber)),a.setContext("InternalSearch",void 0));ATInternet.Utils.isPreview()&&a.getConfig("preview")&&a.setParam("pvw",1);k(null,b.customVars,!1);n(null,b.dynamicLabel,!1);q(null,b.tags,!1);p(null,b.customTreeStructure,!1);c=a.getContext("campaigns")||{};r(null,
c,!1);a.setContext("campaigns",void 0);var b=b.customObject,d=[["hitType",["page"]]];if(b)if(c=a.getParam("stc",!0)){var f=c.options.hitType||[],h=ATInternet.Utils.arrayIndexOf,h=-1!=h(f,"page")||-1!=h(f,"all"),f=c.options.permanent;h?(h=ATInternet.Utils.cloneSimpleObject(c),h.value=ATInternet.Utils.completeFstLevelObj(h.value||{},b,!0),a.setParam("stc",h.value,{encode:!0}),e(function(){a.sendHit(null,d)}),f&&a.setParam("stc",c.value,c.options)):(a.setParam("stc",b,{encode:!0}),e(function(){a.sendHit(null,
d)}),a.setParam("stc",c.value,c.options))}else a.setParam("stc",b,{encode:!0}),e(function(){a.sendHit(null,d)});else e(function(){a.sendHit(null,d)})}};window.ATInternet.Tracker.addPlugin("Page");
}).call(window);;(function(){var dfltPluginCfg={"clicksAutoManagementEnabled":true,"clicksAutoManagementTimeout":500,"info":"False"};var dfltGlobalCfg={};window.ATInternet.Tracker.Plugins.TechClicks=function(a){var b,h;a.configPlugin("TechClicks",dfltPluginCfg||{},function(a){b=a.clicksAutoManagementEnabled;h=a.clicksAutoManagementTimeout});this.deactivateAutoManagement=function(){b=!1};var f=function(a){switch(a.target){case "_top":window.top.location.href=a.url;break;case "_parent":window.parent.location.href=a.url;break;default:window.location.href=a.url}},l=function(a){var b=a.timeout;a.mailto?setTimeout(function(){window.location.href=a.mailto},
b):a.form?setTimeout(function(){a.form.submit()},b):a.url&&setTimeout(function(){f({url:a.url,target:a.target})},b)},g=function(b){for(var c,d="_self",e=b.timeoutonly;b;){if(b.href&&0===b.href.indexOf("http")){c=b.href.split('"').join('\\"');d=b.target?b.target:d;break}b=b.parentNode}if(c){if(!e)a.onTrigger("Tracker:Hit:Sent:Ok",function(){f({url:c,target:d})});l({url:c,target:d,timeout:h})}},c=function(b){var c=b;for(b=c.timeoutonly;c&&"FORM"!==c.nodeName;)c=c.parentNode;if(c){if(!b)a.onTrigger("Tracker:Hit:Sent:Ok",
function(){c.submit()});l({form:c,timeout:h})}},d=function(b){var c=b;for(b=c.timeoutonly;c&&!(c.href&&0<=c.href.indexOf("mailto:"));)c=c.parentNode;if(c){if(!b)a.onTrigger("Tracker:Hit:Sent:Ok",function(){window.location.href=c.href});l({mailto:c.href,timeout:h})}},e=function(a){for(;a;){if(a.href){if(0<=a.href.indexOf("mailto:"))return"mailto";if(0===a.href.indexOf("http"))return"redirection"}else if("FORM"===a.nodeName)return"form";a=a.parentNode}return!1};this.manageClick=function(a,f){if(b&&
a){var h;a:{for(h=a;h;){if("function"===typeof h.getAttribute&&("_blank"===h.getAttribute("target")||"no"===h.getAttribute("data-atclickmanagement"))){h=!0;break a}h=h.parentNode}h=a;for(var l=window.location.href,r;h;){if((r=h.href)&&0<r.indexOf("#")&&l.substring(0,0<l.indexOf("#")?l.indexOf("#"):l.length)===r.substring(0,r.indexOf("#"))){h=!0;break a}h=h.parentNode}h=!1}l=e(a);if(!h&&l){switch(l){case "mailto":d(a);break;case "form":c(a);break;case "redirection":g(a);break;default:return!0}f&&!f.defaultPrevented&&
f.preventDefault();return!1}}return!0}};window.ATInternet.Tracker.addPlugin("TechClicks");
}).call(window);;(function(){var dfltPluginCfg={"info":"False"};var dfltGlobalCfg={};window.ATInternet.Tracker.Plugins.Utils=function(a){var b=this,h={};b.getQueryStringValue=function(a,b){var c=window.ATInternet.Utils.hashcode(b).toString();if(!h[c]){h[c]={};var d=RegExp("[&#?]{1}([^&=#?]*)=([^&#]*)?","g"),e=d.exec(b);if(null!==e)for(;null!==e;)h[c][e[1]]=e[2],e=d.exec(b)}return h[c].hasOwnProperty(a)?h[c][a]:null};b.customObjectToString=function(a){return encodeURIComponent(window.ATInternet.Utils.jsonSerialize(a))};b.manageChapters=function(b,f,c){var d=a.getConfig("ignoreEmptyChapterValue"),
e="";if(b){c=parseInt(c,10);for(var k=1;k<c+1;k++)var n=b[f+k]||"",e=d?e+(n?n+"::":""):e+(b.hasOwnProperty(f+k)?n+"::":"")}return e};b.getDocumentLevel=function(){return window[a.getConfig("documentLevel")]||document};b.getLocation=function(){return b.getDocumentLevel().location.href};a.dispatchIndex={};a.dispatchStack=[];a.dispatchEventFor={};var f=0;a.dispatchSubscribe=function(b){return a.dispatchIndex[b]?!1:(a.dispatchStack.push(b),a.dispatchIndex[b]=!0)};a.dispatchSubscribed=function(b){return!0===
a.dispatchIndex[b]};a.addSpecificDispatchEventFor=function(b){return a.dispatchEventFor[b]?!1:(a.dispatchEventFor[b]=!0,f++,!0)};a.processSpecificDispatchEventFor=function(b){a.dispatchEventFor[b]&&(a.dispatchEventFor[b]=!1,f--,0===f&&(a.dispatchEventFor={},a.emit("Tracker:Plugin:SpecificEvent:Exec:Complete",{lvl:"INFO"})))};a.dispatch=function(){var b=function(){for(;0<a.dispatchStack.length;){var b=a.dispatchStack.pop();a[b].onDispatch()}a.dispatchIndex={};a.delContext(void 0,"customObject")},g=
function(){if(a.plugins.isExecWaitingLazyloading())a.onTrigger("Tracker:Plugin:Lazyload:Exec:Complete",function(){b()},!0);else b()};if(0===f)g();else a.onTrigger("Tracker:Plugin:SpecificEvent:Exec:Complete",function(){g()},!0)};a.dispatchRedirect=function(b){var f=!0;b&&b.elem&&(b.elem.timeoutonly=!0,a.plugins.exec("TechClicks","manageClick",[b.elem],function(a){f=a}));a.dispatch();return f}};window.ATInternet.Tracker.addPlugin("Utils");
}).call(window);
if(typeof window.ATInternet.onTrackerLoad==='function'){window.ATInternet.onTrackerLoad();}