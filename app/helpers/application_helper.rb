module ApplicationHelper
  def dashboard_links
    links = [
        {
            label: 'personal.index',
            links: [
                {label: 'devise.registrations.edit.title', href: edit_user_registration_path},
                {label: 'personal.logs.title', href: personal_logs_path},
            ]
        }
    ]

    links
  end
end
