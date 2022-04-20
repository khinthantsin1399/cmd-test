$(".heightline-branch").heightLine({
  fontSizeCheck: true
});


$(document).ready(function() {
  $('.menu-btn').click(function() {
    $(this).toggleClass('active');
    $('.menu-img').attr('src', '../img/common/close_img.png');
    
    if ($(this).hasClass('active')) {
      $('.nav-inner').addClass('active');
    } else {
      $('.nav-inner').removeClass('active');
      $('.menu-img').attr('src', '../img/common/open_img.png');
    }
  });
});

