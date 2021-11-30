export const schema = {
  table: {
    name: 'users',
    label: 'User'
  },
  fields: [
    {name: 'id', label: 'User ID', readonly: true},
    {name: 'firstName', label: 'First Name'},
    {name: 'lastName', label: 'Last Name'},
    {name: 'username', label: 'Username'},
    {name: 'password', label: 'Password'},
    {name: 'email', label: 'Email'},
    {name: 'dateOfBirth', label: 'Date Of Birth'},
    {name: 'purchases', label: 'User Purchases', references: 'purchases'}
  ],
  references: [
    {name: 'purchases', label: 'Purchases', references: 'purchases'}
  ]
};