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
    <div className='container'>
      <h2>Add Items</h2>
      <div className='row'>
        <label>Name: </label>
        <input id="name-field" className='form-control mt-3' type="text" value={name} onChange={ (e) => setName(e.target.value) }/>
      </div>

      <div className='row'>
        <label>Price: </label>
        <input id="price-field" className='form-control mt-3' type="number" value={price} onChange={ (e) => setPrice(e.target.value) }/>
      </div>

      <div className='row'>
        <label>Type: </label>
        <input id="type-field" className='form-control mt-3' type="text" value={type} onChange={ (e) => setType(e.target.value) }/>
      </div>

      <div className='row'>
        <label>Brand: </label>
        <input id="brand-field" className='form-control mt-3' type="text" value={brand} onChange={ (e) => setBrand(e.target.value) }/>      
      </div>
      <div className='row'>
        <button type="button" className='btn btn-dark mt-3' onClick={addItemsButtonPressed}>Add</button>
      </div>

    </div>
  )
}

export default AddItems;