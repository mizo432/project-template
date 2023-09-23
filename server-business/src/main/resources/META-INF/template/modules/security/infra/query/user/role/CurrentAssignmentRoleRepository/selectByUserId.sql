select role_code
from security.role
         inner join security.assignment_role ar on role.role_id = ar.role_id
         left join security.unassignment_role ur on ar.assignment_role_id = ur.assignment_role_id

where ar.user_id = /* userId */1
  and ar.when_occurred < current_date
  and ur.when_occurred is null