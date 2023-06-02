
export default function Pergunta({par, par2="Valor padrão"}){

  par = "Valor modificado 1"
  
    var title = "Isso é um Título"
    var flag = false;
  
    if (flag = true){
      return (
        <div>
          {title}
          <h1>Perguntas</h1>
          <p>Pergunta vem aqui</p>
          <p>Variável passada: {par}</p>
          <p>Variável passada 2: {par2}</p>
        </div>
      );
    }else{
      return (<p>NO TITLE</p>)
  
    }
  
  }

