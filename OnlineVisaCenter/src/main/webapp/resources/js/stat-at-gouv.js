jQuery(document).ready(function() {
	var titrePage = document.title;
	var langueUser = $("[name$='_languageId']").val();
	var urlPage = window.location.pathname;

	// On prend quelques prÃ©cautions si jamais le site de stats@gouv est
	// injoignable
	if (typeof ATInternet != "undefined") {
		var tag = new ATInternet.Tracker.Tag();

		tag.page.send({
			name : titrePage,
			customObject : {
				url : urlPage,
				langue : langueUser
			}
		});
	} else {
		console.error("stats@gouv unreachable");
	}
})