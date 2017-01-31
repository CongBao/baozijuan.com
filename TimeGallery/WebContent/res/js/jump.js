/* !
 * Time Gallery (www.baozijuan.com)
 * Copyright (C) 2016-2017 Bao Cong.
 */

// set the progress bar to the middle of screen
var proObj = document.getElementById('pro');
proObj.style.marginTop = window.innerHeight / 2 - 100 + "px";

// increase the progress
var proBar = document.getElementById('bar');
var proSro = document.getElementById('sro');
var timer = setInterval(progress, 50);
var counter = 0;

function progress() {
	if (counter <= 115) {
		proObj.style.marginTop = window.innerHeight / 2 - 100 + "px";
		proBar.setAttribute("aria-valuenow", counter);
		proBar.style.width = counter + "%";
		proSro.innerHTML = counter + "% Complete";
		counter = counter + 1;
	} else {
		clearInterval(timer);
		window.location.href = "/TimeGallery/login";
	}
}