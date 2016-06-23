define('content_view',['jquery', 'underscore', 'backbone', 'base_view', 'content_template'], 
       function($, _, Backbone, BaseView, template) {
                            
           return Backbone.View.extend(_.extend(BaseView, {
               tooltip: null,
                              
               rendering: function(){                                       
                   this.$el.append(template());           
               }
          }));
           
       });