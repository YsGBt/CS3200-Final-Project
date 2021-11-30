export const schema = {
  table: {
    name: 'ebooks',
    label: 'Ebook'
  },
  fields: [
    {name: 'id', label: 'Ebook ID', readonly: true},
    {name: 'title', label: 'Ebook Title'},
    {name: 'publishedYear', label: 'Ebook Published Year'},
    // {name: 'genre', label: 'Ebook Genre'},
    // {name: 'author', label: 'Ebook Author'},
    {name: 'purchases', label: 'Ebook Purchases', references: 'purchases'}
  ],
  references: [
    {name: 'purchases', label: 'Purchases', references: 'purchases'}
  ]
};