import logo from './logo.svg';
import './App.css';
import Pergunta from './Pergunta.js';
import { useState } from 'react'; 
import SearchBar from './SearchBar';
import AddItems from './AddItems';
import ItemsDisplay from './ItemsDisplay';
import styles from './App.module.css'
import styled from 'styled-components'

const Title = styled.h1`
  color: ${(props) => props.color ? props.color : 'black'}
`

function App() {
  
  const [data, setData] = useState({items: []})
  const [filters, setFilters] = useState({})
  const updateData = (searchParam) => {
    console.log(searchParam)
    setFilters(searchParam)
  }



  const filterData = (data) => {
    const filteredData = []
  
    for (const item of data){
      if (filters.name !== item.name && filters.name !== ""){
        continue
      }

      if (item.price > filters.price && filters.price !== 0){
        continue
      }

      if (filters.type !== item.type && filters.type !== ""){
        continue
      }

      if (filters.brand !== item.brand && filters.brand !== ""){
        continue
      }

      filteredData.push(item)
      
    }
  
    return filteredData
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
      <p className={styles.gray} >Hello</p>
      <Title color='green'>Hello2</Title>
      <p style={{
        color: "green",
        fontSize: 40
      }}>Um texto qualquer</p>

      <ItemsDisplay items={filterData(data['items'])} />

      <SearchBar callback={updateData}/>
      <p>Name: {"name" in data ? data['name'] : "Nada para exibir"}</p>
      <p>Price: {"price" in data ? data['price'] : "Nada para exibir"}</p>
      <p>Type: {"type" in data ? data['type'] : "Nada para exibir"}</p>
      <p>Brand: {"brand" in data ? data['brand'] : "Nada para exibir"}</p>

      <AddItems addItems={addItemToData}/>
      
    </div>
  );
}


export default App;
