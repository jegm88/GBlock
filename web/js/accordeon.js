
$(document).ready(function() {
    var accordion_head = $('.accordion > li > a');
    var accordion_body = $('.accordion li > .sub-menu');
    accordion_head.first().addClass('active').next().slideDown('normal');
    accordion_head.on('click', function(event) {
        event.preventDefault();
        if ($(this).attr('class') !== 'active') {
            accordion_body.slideUp('normal');
            $(this).next().stop(true, true).slideToggle('normal');
            accordion_head.removeClass('active');
            $(this).addClass('active');
        }
    });
});
