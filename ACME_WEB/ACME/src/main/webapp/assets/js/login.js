

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
	var userId = $("#userId").val();
	setCookie("ACME_USER_ID", userId.toUpperCase());
}

function logout() {
	setCookie("ACME_USER_ID", "");
}