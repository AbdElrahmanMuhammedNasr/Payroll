$(function (){

  $('.cal').animate({
    height:'0px',
    width: '0px'


  },1000);

  $('.cal').animate({
        height:'0px',
        width: '400px'

    },1000);

     $('.cal').animate({
        height:'400px',
    },1000);
/***************************************************/
    $('#but').click(function(){
      $('.register').css({
        'transform':"scaleX(0)",
        'transform':"scaleY(0)"
      });

      $('.cal').css({
        'transform':"scaleX(1)",
        'transform':"scaleY(1)"
      });

    });

/****************** second part*********************************/


    $('#cl').click(function(){
      $('.cal').animate({
        'marginTop':'200px',
        'marginLeft':'450px',
      },2000);



      $('.method').css({
        'transform':"scaleX(1)",
        'transform':"scaleY(1)"
      },1000);

    });

    $('#help').click(function(){
        $('.cal').css({
          'transform':"scaleX(0)",
          'transform':"scaleY(0)"
        });


        $('.register').css({
          'transform':"scaleX(1)",
          'transform':"scaleY(1)"
        },2000);

        $('.method').css({
          'transform':"scaleX(0)",
          'transform':"scaleY(0)"
        },2000);

      });

/*****************************third part***********/
  /*  $('#re').click(function(){
      $('.method').slideUp(500);
      $('.cal').slideUp(500);
      $('.register').slideDown(500);

    });*/
  });
