export const schema = {
  table: {
    name: 'authors',
    label: 'Author'
  },
  fields: [
    {name: 'id', label: 'Author ID', readonly: true},
    {name: 'firstName', label: 'First Name'},
    {name: 'lastName', label: 'Last Name'},
    {name: 'dateOfBirth', label: 'Date Of Birth'},
    {name: 'ebooks', label: "Author's Ebooks", references: 'ebooks'}
  ],
  references: [
    {name: 'ebooks', label: 'Ebooks', references: 'ebooks'}
  ]
};