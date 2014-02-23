$(function() {
	
	// colorbox
	$(".colorbox").colorbox();
	$(".colorbox").colorbox({iframe:true, width:"80%", height:"80%"});
	
	// subMenu categorias
	$('.ulSubMenu').hide();
	$('.subMenu').mouseover(function() {
		$('.ulSubMenu').show();
	});
	$('.subMenu').mouseout(function() {
		$('.ulSubMenu').hide();
	});
	
	// cart
	$('#cartItensMarcas').hide();
	
	/*
	$(".cart").mouseover(function() {
		$('#cartItensMarcas').slideDown();
        }).mouseleave(function() {
        	if ($('#cartItensMarcas').is(':hover')) {
        		$('#cartItensMarcas').show();
            }else{
            	$('#cartItensMarcas').slideUp();
            }
            });
	*/
	
	$(".cart").mouseenter(function(){
	    clearTimeout($(this).data('timeoutId'));
	    $(this).find("#cartItensMarcas").slideDown();
	}).mouseleave(function(){
	    var someElement = $(this);
	    var timeoutId = setTimeout(function(){
	        someElement.find("#cartItensMarcas").slideUp();
	    }, 300);
	    //set the timeoutId, allowing us to clear this trigger if the mouse comes back over
	    someElement.data('timeoutId', timeoutId); 
	});
	
	/* Codigo antigo

	$('.cart').mouseover(function(){
		$('#cartItensMarcas').show();
	});
	$('#cartItensMarcas').mouseout(function(){
		$('#cartItensMarcas').hide();
	});
	
	*/
	// produto
	$('#products').slides({
		preload: false,
		preloadImage: 'img/loading.gif',
		effect: 'slide', //slide, fades
		crossfade: true,
		slideSpeed: 250,
		fadeSpeed: 250,
		generateNextPrev: true,
		generatePagination: false
	});
	
	// zoom produto
	$('.jqzoom').jqzoom({
        zoomType: 'standard',
        lens: true,
        preloadImages: false,
        alwaysOn: false
    });
	
	// msg
	$('.icoClose').click(function() {
		$('.msg').fadeOut();
	});
	

});	