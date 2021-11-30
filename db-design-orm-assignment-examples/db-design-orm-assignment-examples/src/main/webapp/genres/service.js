const URL = "http://localhost:8080/api";

export const findAllRecords = (table) =>
  fetch(`${URL}/${table}`)
    .then(response => response.json());

export const findRecordById = (table, genre) =>
  fetch(`${URL}/${table}/${genre}`)
    .then(response => response.json());

export const findOneToManyRecords = (oneTable, genre, manyTable) =>
  fetch(`${URL}/${oneTable}/${genre}/${manyTable}`)
    .then(response => response.json());

export const removeRecord = (table, genre) =>
  fetch(`${URL}/${table}/${genre}/remove`);

export const createRecord = (table) =>
  fetch(`${URL}/${table}/create`);

export const updateRecord = (table, newRecord) =>
  fetch(`${URL}/${table}`, {
    method: 'PUT',
    body: JSON.stringify(newRecord),
    headers: {
      'content-type': 'application/json'
    }
  });

// TODO: export all functions as the API to this service
export default {
  findAllRecords,
  findRecordById,
  findOneToManyRecords,
  removeRecord,
  createRecord,
  updateRecord
}
