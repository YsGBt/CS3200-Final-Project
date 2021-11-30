export const schema = {
  table: {
    name: 'genres',
    label: 'Genre'
  },
  fields: [
    {name: 'genre', label: 'Genre', readonly: true},
    {name: 'ebooks', label: 'Genre Ebooks', references: 'ebooks'}
  ],
  references: [
    {name: 'ebooks', label: 'Ebooks', references: 'ebooks'}
  ]
};