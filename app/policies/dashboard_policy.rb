class DashboardPolicy < Struct.new(:user, :dashboard)
  def update?
    !user.nil? && user.is_admin?
  end
end

