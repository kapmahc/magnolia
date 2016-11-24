$( document ).on('turbolinks:load', function() {
   var md = new Remarkable();
   $('.markdown').each(function(){
      $(this).html(md.render($(this).text()));
   });
});