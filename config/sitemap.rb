# Set the host name for URL creation
SitemapGenerator::Sitemap.default_host = "https://#{ENV['HOST']}"

# Ops.sitemap
# Forum.sitemap

SitemapGenerator::Sitemap.create do
  %w(Forum Ops).each do |en|
    Object.const_get(en).sitemap.each do |l|
      add l.fetch(:url), lastmod: l[:lastmod]
    end
  end


  Setting.languages.each do |l|
    add notices_path(locale: l)
    add new_leave_word_path(locale: l)

    add new_user_session_path(locale: l)
    add new_user_registration_path(locale: l)
    add new_user_password_path(locale: l)
    add new_user_confirmation_path(locale: l)
    add new_user_unlock_path(locale: l)
  end

  # Put links creation logic here.
  #
  # The root path '/' and sitemap index file are added automatically for you.
  # Links are added to the Sitemap in the order they are specified.
  #
  # Usage: add(path, options={})
  #        (default options are used if you don't specify)
  #
  # Defaults: :priority => 0.5, :changefreq => 'weekly',
  #           :lastmod => Time.now, :host => default_host
  #
  # Examples:
  #
  # Add '/articles'
  #
  #   add articles_path, :priority => 0.7, :changefreq => 'daily'
  #
  # Add all articles:
  #
  # Forum::Article.find_each do |article|
  #   add forum.article_path(article), :lastmod => article.updated_at
  # end
end
