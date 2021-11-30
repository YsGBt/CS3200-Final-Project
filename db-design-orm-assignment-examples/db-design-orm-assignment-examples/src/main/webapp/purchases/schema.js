export const schema = {
  table: {
    name: 'purchases',
    label: 'Purchase'
  },
  fields: [
    {name: 'id', label: 'Purchase ID', readonly: true},
    {name: 'purchaseDate', label: 'Purchase Date'},
    // {name: 'user', label: 'Purchase User'},
    // {name: 'ebook', label: 'Purchase Ebook'}
  ]
};