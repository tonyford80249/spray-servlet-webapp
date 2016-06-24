define('modal_view',['jquery', 'underscore', 'backbone', 'base_view','bootstrap', 'text!html/modal.html'],
       function($, _, Backbone, BaseView, html) {
  
           return Backbone.View.extend(_.extend(BaseView, {
              
               rendering: function(){
                   this.$el.append(html);
               }
           }));
           
       });