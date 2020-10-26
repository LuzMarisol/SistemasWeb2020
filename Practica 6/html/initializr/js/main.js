var bLogeo = document.getElementById('signin');
//bLogeo.innerHTML = "algo"
bLogeo.addEventListener('click', function() { //acción de escucha
  //alert('hola ' + document.getElementById('email').value);
  const parametros = new URLSearchParams();//Enviar estos parametros de el Login y el password a algo más  //Convertira a parametros  
  parametros.append('PrtEmail', document.getElementById('email').value);
  parametros.append('PrtPassword', document.getElementById('password').value);
  //alert(parametros)

/* axios.get('http://127.0.0.1:4567/usuarios/' + parametros, parametros)
     .then(function (response) {
       console.log(response)
       console.log(response.data)
       console.log(response.status)
       document.getElementById('titulo').innerHTML = response.data
      })
          .catch(function(error){
           console.log(error)
    })
  }) */

/* axios.get('http://127.0.0.1:4567/queryparms?' + parametros)
        .then(function (response) {
         console.log(response)
         document.getElementById('titulo').innerHTML = response.data
        })
          .catch(function (error) {
               console.log(error);
       })
}) */
axios.post('http://127.0.0.1:4567/usuarios', {
   PrtEmail : document.getElementById('email').value,
   PrtPassword :document.getElementById('password').value
  })
  .then(function (response) {
    console.log(response)
    console.log(response.data)
    console.log(response.status)
    document.getElementById('titulo').innerHTML = response.data
    })
    .catch(function(error){
      console.log(error)
    })
  })


  // axios.get('http://127.0.0.1:4567/hello/' + parametros, parametros)
  //      .then(function (response) {
  //          console.log(response)
  //          console.log(response.data)
  //          console.log(response.status)
  //          document.getElementById('titulo').innerHTML = response.data
  //      })
  //      .catch(function(error){
  //         console.log(error)
//)}