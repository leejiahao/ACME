

/**
 * set cookie
 * 
 * ref: http://stackoverflow.com/questions/1458724/how-to-set-unset-cookie-with-jquery
 * @param key
 * @param value
 */
function setCookie(key, value) {
    var expires = new Date();
    expires.setTime(expires.getTime() + (1 * 24 * 60 * 60 * 1000));
    document.cookie = key + '=' + value + ';expires=' + expires.toUTCString();
}

function getCookie(key) {
    var keyValue = document.cookie.match('(^|;) ?' + key + '=([^;]*)(;|$)');
    return keyValue ? keyValue[2] : null;
} 

function login() {
    	//window.location.href = "http://localhost:8080/ACME/main.html";
    	//alert('a');
    	//var url = "main.html";    
    	//$(location).attr('href',url);
    	
    	//window.location.href = "http://localhost:8080/ACME/main.html";
    	//alert('b');
    	
    	var userId = $("#userId").val();
    	//alert(userId);
    	setCookie("ACME_USER_ID", userId);
    	
    	$.cookie("ACME_USER_ID", userId, {
    		   expires : 10,           //expires in 10 days

    		   path    : '/',          //The value of the path attribute of the cookie 
    		                           //(default: path of page that created the cookie).

    		   domain  : 'localhost',  //The value of the domain attribute of the cookie
    		                           //(default: domain of page that created the cookie).

    		   secure  : true          //If set to true the secure attribute of the cookie
    		                           //will be set and the cookie transmission will
    		                           //require a secure protocol (defaults to false).
    		});
    	
    	//var cookieValue = $.cookie("test");
    	//var cookieValue = $.cookie("test", { path: '/foo' });
    }