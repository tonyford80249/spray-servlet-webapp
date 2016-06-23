define('modal_view',['jquery', 'underscore', 'backbone', 'base_view','bootstrap'], 
       function($, _, Backbone, BaseView) {
  
           return Backbone.View.extend(_.extend(BaseView, {
              
               rendering: function(){
                   this.$el.append('\
                        <div id="help" class="modal fade" role="dialog">\
                           <div class="modal-dialog">\
                              <div class="modal-content">\
                                 <div class="modal-header">\
                                    <h4>Help Search Page</h4>\
                                 </div>\
                                 <div class="modal-body">\
                                    <h5>This a T-FORD production.</h5>\
                                    <p>find what ever you want.</p>\
                                 </div>\
                                 <div class="modal-footer"><a href="#" class="btn btn-default">Canel</a><a href="#" class="btn btn-primary" data-dismiss="modal">Close</a></div>\
                              </div>\
                           </div>\
                        </div>\
                    ');
               }
           }));
           
       });