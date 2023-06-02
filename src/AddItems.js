import { useState } from 'react'; 

/*
{
  name:
  price:
  type:
  brand:
}
*/
function AddItems(props){

    const [name, setName] = useState("")
    const [price, setPrice] = useState(0)
    const [type, setType] = useState("")
    const [brand, setBrand] = useState("")

    const addItemsButtonPressed = () => {
      props.addItems({
            "name": name,
            "price": price,
            "type": type,
            "brand": brand
        })

    setName("")
    setPrice(0)
    setType("")
    setBrand("")
    }

  return (
    <div>
      <h2>Add Items</h2>
      <form>
        <label>Name: </label>
        <input id="name-field" type="text" value={name} onChange={ (e) => setName(e.target.value) }/>
        <br />
        <label>Price: </label>
        <input id="price-field" type="number" value={price} onChange={ (e) => setPrice(e.target.value) }/>
        <br />
        <label>Type: </label>
        <input id="type-field" type="text" value={type} onChange={ (e) => setType(e.target.value) }/>
        <br />
        <label>Brand: </label>
        <input id="brand-field" type="text" value={brand} onChange={ (e) => setBrand(e.target.value) }/>      
        <br />                  
        <button type="button" onClick={addItemsButtonPressed}>Add</button>
      </form>


    </div>
  )
}

export default AddItems;