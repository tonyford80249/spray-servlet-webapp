 define('base_view',
    function() {
        return {
            beforeRendering: function() {
             return null;        
            },
            afterRendering: function(){
             return null;    
            },
            rendering: function(){
             return null;
            },
            render: function(option){
                var promise = null,
                    self = this;
                
                promise = this.beforeRendering(option);   
                
                if (promise) {
                 promise.done(function(data){
                   var promise = self.rendering(data);
                     
                   if (promise) {
                    promise.done(function(data){self.afterRendering(data)});   
                   }
                     else {
                      self.afterRendering();     
                     }
                 });
                }
                 else {
                  promise = self.rendering();   
                  
                  if (promise) {
                    promise.done(function(data){self.afterRendering(data)});   
                   }
                     else {
                      self.afterRendering();     
                     }
                 }
                
            },
            assign : function (view, selector) {
                view.setElement(this.$(selector)).render();
            },
            unassign: function(view) {            
             view.remove();   
             view.unbind();    
            }
        };
    });
        