//head-slide
$('.h-slider-sub').slick({
    dots: true,
    infinite: true,
    speed: 500,
    fade: true,
    arrows: false,
    cssEase: 'linear'
  });
  $('.h-right').slick({
    slidesToShow: 5,
    slidesToScroll: 1,
    asNavFor: '.h-slider-sub',
    dots: false,
    centerMode: false,
    arrows: false,
    focusOnSelect: true,
    vertical: true
  });
  
  
  
  //branches-slide
  $('.center').slick({
    centerMode: true,
    centerPadding: '160px',
    slidesToShow: 1.67,
    arrows: false,
    asNavFor: '.bran-slide-slt',
    responsive: [
      {
        breakpoint: 1040,
        settings: {
          arrows: false,
          centerMode: true,
          centerPadding: '26px',
          slidesToShow: 1.78
        }
      },
      {
        breakpoint: 768,
        settings: {
          arrows: false,
          centerMode: true,
          centerPadding: '0px',
          slidesToShow: 1.76
        }
      }
    ]
  });
  
  $('.bran-slide-slt').slick({
    slidesToShow: 1.67,
    slidesToScroll: 1,
    asNavFor: '.center',
    centerPadding: '98px',
    dots: false,
    centerMode: true,
    arrows: false,
    focusOnSelect: true,
    vertical: false,
    responsive: [
      {
        breakpoint: 1040,
        settings: {
          arrows: false,
          centerMode: true,
          centerPadding: '80px',
          slidesToShow: 1.7
        }
      },
      {
        breakpoint: 768,
        settings: {
          arrows: false,
          centerMode: true,
          centerPadding: '78px',
          slidesToShow: 1.5
        }
      }
    ]
  });
  
  
  


if ($(window).width() >= 768 && $(window).width() <= 1040) {
    $('.menu-slide').slick({
        infinite: true,
        variableWidth: true,
        slidesToShow: 3,
        slidesToScroll: 3,

    });
}
else if ($(window).width() < 767.9) {
    $('.menu-slide').slick({
        infinite: true,
        variableWidth: true,
        slidesToShow: 2,
        slidesToScroll: 2,
    });
}
else {
    $('.menu-slide').slick({
        infinite: true,
        variableWidth: true,
        slidesToShow: 4,
        slidesToScroll: 4,
    });
}