# Filters added to this controller apply to all controllers in the application.
# Likewise, all the methods added will be available for all controllers.

class Spring
  def initialize(real_context)
    @real_context = real_context
  end

  def [](bean_name)
    @real_context.getBean(bean_name.to_s)
  end
end

class ApplicationController < ActionController::Base
  helper :all # include all helpers, all the time

  # See ActionController::RequestForgeryProtection for details
  # Uncomment the :secret if you're not using the cookie session store
  protect_from_forgery # :secret => '9346baedc099926e71cc3a3f39613aa6'
  
  # See ActionController::Base for details 
  # Uncomment this to filter the contents of submitted sensitive data parameters
  # from your application log (in this case, all fields with names like "password"). 
  # filter_parameter_logging :password

  import org.springframework.web.context.support.WebApplicationContextUtils

  def spring
    return @spring if @spring
    
    ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet_request.getSession.getServletContext)
    @spring ||= Spring.new(ctx)
  end

  def comments_repository
    spring[:commentsRepository]
  end

  def articles_repository
    spring[:articlesRepository]
  end

end
