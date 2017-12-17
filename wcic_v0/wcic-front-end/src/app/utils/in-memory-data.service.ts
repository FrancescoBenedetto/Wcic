import { InMemoryDbService } from 'angular-in-memory-web-api';

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    let dishes = [
{'id': 1,
'name': 'Amatriciana',
'instructions': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra, eros. Lorem ipsum dolor sit amet, consectetur adipiscing elit',
'type': 'primo',
'ingredients': [{'id': 1, 'name': 'pancetta'}, {'id': 2, 'name': 'spaghetti'}]
},
{
'id': 2,
'name': 'Carbonara',
'instructions': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra, eros...',
'type': 'primo',
'ingredients': [{'id': 1, 'name': 'uovo'}, {'id': 2, 'name': 'spaghetti'}]
},
{
'id': 3,
'name': 'Trippa',
'instructions': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra, eros...',
'type': 'secondo',
'ingredients': [{'id': 1, 'name': 'trippa'}, {'id': 2, 'name': 'fagioli'}]
},
{
'id': 4,
'name': 'Sandwich',
'instructions': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra, eros...',
'type': 'primo',
'ingredients': [{'id': 1, 'name': 'prosciutto'}, {'id': 2, 'name': 'pane'}]
},
{
'id': 5,
'name': 'Cacio e Pepe',
'instructions': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse varius enim in eros elementum tristique. Duis cursus, mi quis viverra, eros...',
'type': 'primo',
'ingredients': [{'id': 1, 'name': 'cacio'}, {'id': 2, 'name': 'pepe'}, {'id': 3, 'name': 'pasta'}]
}
];

let ingredients = [
      {id: 11, name: 'Spaghetti'},
      {id: 12, name: 'Panna'},
      {id: 13, name: 'Sugo'},
      {id: 14, name: 'Pancetta'},
      {id: 15, name: 'Pepe'},
      {id: 16, name: 'Zafferano'},
      {id: 17, name: 'Pane'},
      {id: 18, name: 'Zucchero'},
      {id: 19, name: 'Ananas'},
      {id: 20, name: 'Pera'}
    ];

    return {dishes, ingredients};
  }
}
