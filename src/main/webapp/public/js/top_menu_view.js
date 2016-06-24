define('top_menu_view',['jquery', 'underscore', 'backbone', 'base_view', 'text!html/new_top_menu.html'],
       function($, _, Backbone, BaseView, html) {
  
           return Backbone.View.extend(_.extend(BaseView, {
               
               rendering: function() {
                   $(this.el).append(html);
               }
           }));
  
});

