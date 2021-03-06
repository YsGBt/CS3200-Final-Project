const URL = "http://localhost:8080/api";

export const findAllRecords = (table) =>
  fetch(`${URL}/${table}`)
    .then(response => response.json());

export const findRecordById = (table, id) =>
  fetch(`${URL}/${table}/${id}`)
    .then(response => response.json());

export const findOneByMany = (many, id, one) =>
  fetch(`${URL}/${many}/${id}/${one}/manytoone`)
    .then(response => response.json());

export const findOneToManyRecords = (oneTable, id, manyTable) =>
  fetch(`${URL}/${oneTable}/${id}/${manyTable}`)
    .then(response => response.json());

export const removeRecord = (table, id) =>
  fetch(`${URL}/${table}/${id}/remove`);

export const createRecord = (table) =>
    fetch(`${URL}/${table}/create`);

export const createOneToMany = (oneTable, id, manyTable) =>
    fetch(`${URL}/${oneTable}/${id}/${manyTable}/create`);

export const updateRecord = (table, newRecord) =>
  fetch(`${URL}/${table}`, {
    method: 'PUT',
    body: JSON.stringify(newRecord),
    headers: {
      'content-type': 'application/json'
    }
  });

export default {
  findAllRecords,
  findRecordById,
  findOneToManyRecords,
  removeRecord,
  createRecord,
  createOneToMany,
  updateRecord,
  findOneByMany
}
