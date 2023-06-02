import logo from './logo.svg';
import './App.css';
import Pergunta from './Pergunta.js';
import { useState } from 'react'; 
import SearchBar from './SearchBar';
import AddItems from './AddItems';
import ItemsDisplay from './ItemsDisplay';

function App() {
  
  const [data, setData] = useState({items: []})
  const [filters, setFilters] = useState({})
  const updateData = (searchParam) => {
    console.log(searchParam)
    setData(searchParam)
  }

  const addItemToData = (item) => {
    //console.log("Items: ")
    //console.log(items)
    let items = data['items']
    item.id = items.length
    items.push(item)
    setData({items: items})
    console.log(data)
  }

  return (
    <div className="App">
      <p>Hello</p>

      <SearchBar callback={updateData}/>
      <p>Name: {"name" in data ? data['name'] : "Nada para exibir"}</p>
      <p>Price: {"price" in data ? data['price'] : "Nada para exibir"}</p>
      <p>Type: {"type" in data ? data['type'] : "Nada para exibir"}</p>
      <p>Brand: {"brand" in data ? data['brand'] : "Nada para exibir"}</p>

      <AddItems addItems={addItemToData}/>
      <ItemsDisplay items={data['items']} />
    </div>
  );
}


export default App;
