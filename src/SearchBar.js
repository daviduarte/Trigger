import { useState } from 'react'; 

/*
{
  name:
  price:
  type:
  brand:
}
*/
function SearchBar(props){

    const [name, setName] = useState("")
    const [price, setPrice] = useState(0)
    const [type, setType] = useState("")
    const [brand, setBrand] = useState("")

    const searchButtonPressed = () => {
      console.log(name)
      console.log(price)
      console.log(type)
      console.log(brand)

      props.callback({
            "name": name,
            "price": price,
            "type": type,
            "brand": brand
        })
    }

  return (
    <div className='container'>

    <div className='row'>
      <h2 className='gray'>Search Items</h2>
      
      
        <div className='col mt-3'>
          <label>Name: </label>
          <input id="name-field" type="text" className='form-control' value={name} onChange={ (e) => setName(e.target.value) }/>
        </div>

        <div className='col mt-3'>
          <label>Max Price: </label>
          <input id="price-field" type="number" className='form-control' value={price} onChange={ (e) => setPrice(e.target.value) }/>
        </div>

        <div className='col mt-3'>
          <label>Type: </label>
          <input id="type-field" type="text" className='form-control' value={type} onChange={ (e) => setType(e.target.value) }/>
        </div>
          
        <div className='col mt-3'>
          <label>Brand: </label>
          <input id="brand-field" type="text" className='form-control' value={brand} onChange={ (e) => setBrand(e.target.value) }/>      
        </div>
          
      
        <div className='row mt-3'>
          <div className='col-4' />
            <button type="button" onClick={searchButtonPressed} className='btn btn-dark col-4' >Search</button>
        </div>   
      </div>   
    </div>
  )
}

export default SearchBar;