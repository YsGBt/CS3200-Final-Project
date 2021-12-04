
export const schema = {
  tables: [
    {
      name: 'authors',
      label: 'Author',
      labelPlural: 'Authors',
      fields: [
        {name: 'id', label: 'Author ID', readonly: true},
        {name: 'firstName', label: 'First Name'},
        {name: 'lastName', label: 'Last Name'},
        {name: 'dateOfBirth', label: 'Date Of Birth'},
      ],
      relations: [
        {name: 'ebooks', label: "Author's Ebooks", references: 'ebooks'}
      ],
      list: {
        id: { show: false },
        firstName: { show: true },
        lastName: { show: true },
        dateOfBirth: { show: false },
      }
    },
    {
      name: 'ebooks',
      label: 'Ebook',
      labelPlural: 'Ebooks',
      fields: [
        {name: 'id', label: 'Ebook ID', readonly: true},
        {name: 'title', label: 'Ebook Title'},
        {name: 'publishedYear', label: 'Ebook Published Year'},
        {name: 'genreType', label: 'Genre', readonly: false},
        {name: 'authorId', label: 'Author ID', readonly: false},
        {name: 'authorName', label: 'Author Name', readonly: true}
      ],
      relations: [
        {name: 'purchases', label: "Purchased Record", references: 'purchases'}
      ],
      manyToOne: [
        {name: 'author', label: "Ebook's Author", references: 'authors'},
        {name: 'genre', label: 'Ebook Genre', references: 'genres'}
      ],
      list: {
        id: { show: false },
        title: { show: true },
        publishedYear: { show: false },
        genre: { show: false },
        author: { show: false },
        genreType: { show: false},
        authorId: { show: false},
        authorName: { show: false },
      }
    },
    {
      name: 'genres',
      label: 'Genre',
      labelPlural: 'Genres',
      fields: [
        {name: 'id', label: 'Genre', readonly: true},
      ],
      relations: [
        {name: 'ebooks', label: "Ebooks With Genre", references: 'ebooks'}
      ],
      list: {
        id: { show: true },
      }
    },
    {
      name: 'purchases',
      label: 'Purchase',
      labelPlural: 'Purchases',
      fields: [
        {name: 'id', label: 'Purchase ID', readonly: true},
        {name: 'purchaseDate', label: 'Purchase Date'},
        {name: 'userId', label: 'Purchaser ID', readonly: false},
        {name: 'userName', label: 'Purchaser Name', readonly: true},
        {name: 'ebookId', label: 'Ebook ID', readonly: false},
        {name: 'ebookName', label: 'Purchased Ebook', readonly: true},
      ],
      manyToOne: [
        {name: 'users', label: "Purchaser", references: 'users'},
        {name: 'ebooks', label: 'Purchased Ebook', references: 'ebooks'}
      ],
      list: {
        id: { show: false },
        purchaseDate: { show: false },
        userId: { show: false },
        userName: { show: true },
        ebookId: { show: false },
        ebookName: { show: true },
      }
    },
    {
      name: 'users',
      label: 'User',
      labelPlural: 'Users',
      fields: [
        {name: 'id', label: 'User ID', readonly: true},
        {name: 'firstName', label: 'First Name'},
        {name: 'lastName', label: 'Last Name'},
        {name: 'username', label: 'Username'},
        {name: 'password', label: 'Password'},
        {name: 'email', label: 'Email'},
        {name: 'dateOfBirth', label: 'Date Of Birth'},
      ],
      relations: [
        {name: 'purchases', label: "User's Purchases", references: 'purchases'}
      ],
      list: {
        id: { show: false },
        firstName: { show: true },
        lastName: { show: true },
        username: { show: false },
        password: { show: false },
        email: { show: false },
        dateOfBirth: { show: false },
      }
    }
  ]
};