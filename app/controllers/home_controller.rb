class HomeController < ApplicationController
  before_action :authenticate_user!, only: [:dashboard]

  def index
    redirect_to send(Setting.home).root_path
  end

  def dashboard
    render layout: 'dashboard'
  end

  def robots

    render plain: <<EOF
# See http://www.robotstxt.org/robotstxt.html for documentation on how to use the robots.txt file
#
# To ban all spiders from the entire site uncomment the next two lines:
# User-agent: *
# Disallow: /
EOF
  end

  def google
    code = Setting.google_verify_code
    if params[:id] == code
      render plain: "google-site-verification: google#{code}.html"
    else
      head :not_found
    end
  end

  def baidu
    code = Setting.baidu_verify_code
    if params[:id] == code
      render plain: code
    else
      head :not_found
    end
  end
end
