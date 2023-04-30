async function createPersona() {
  try {
    const event = window.event;
    event.preventDefault(); // prevent default form submission behavior
    const username = document.getElementById("NOMBRE").value;
    const lastname = document.getElementById("APELLIDOS").value;
    const email = document.getElementById("EMAIL").value;
    const phone = document.getElementById("TELEFONO").value;

    // Crear un objeto usuario
    const usuario = {
      "username": username,
      "lastname": lastname,
      "email": email,
      "phone": phone,
    };
    
    
    const response = await fetch('http://localhost:8080/Usuarios/post', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(usuario)
    });
    
    if (!response.ok) {
      throw new Error('Error en la respuesta del servidor');
    }
    
    const data = await response.json();
    console.log(data);
    alert('Usuario creado correctamente');
    
  } catch (error) {
    alert('Error en la petición: ' + error.message);
    console.error(error);
  }
}




//devolver todos los usuarios
async function searchPersonas() {
  try {
    const response = await fetch('http://localhost:8080/Usuarios/getAll', {
      method: 'GET'
    });

    if (!response.ok) {
      throw new Error('Error en la respuesta del servidor');
    }
    const data = await response.json();
    console.log(data);

    alert('Los usuarios registrados son:  ' + data[0].username + '...' );
    
  } catch (error) {
    alert('Error en la petición: ' + error.message);
    console.error(error);
  }
}



//BUSCAR UN USUARIO
async function searchPersona() {
  try {
    const event = window.event;
    event.preventDefault(); // prevent default form submission behavior
    const username = document.getElementById("NOMBRE").value;
    const lastname = document.getElementById("APELLIDOS").value;
    const email = document.getElementById("EMAIL").value;
    const phone = document.getElementById("TELEFONO").value;

    // Crear un objeto usuario
    const usuario = {
      "username": username,
      "lastname": lastname,
      "email": email,
      "phone": phone,
    };
    
    const response = await fetch('http://localhost:8080/Usuarios/buscar', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(usuario)
    });
    
    if (!response.ok) {
      throw new Error('Error en la respuesta del servidor');
    }
    
    const data = await response.json();
    console.log(data);
    alert('Usuario creado correctamente');
    
  } catch (error) {
    alert('Error en la petición: ' + error.message);
    console.error(error);
  }
}




///ELIMINAR USUARIO POR ID
async function deleteUsuario() {
  try {
    const event = window.event;
    event.preventDefault(); // prevent default form submission behavior
    const username = document.getElementById("NOMBRE").value;
    const lastname = document.getElementById("APELLIDOS").value;
    const email = document.getElementById("EMAIL").value;
    const phone = document.getElementById("TELEFONO").value;

    // Crear un objeto usuario
    const usuario = {
      "username": username,
      "lastname": lastname,
      "email": email,
      "phone": phone
    };
  
    const response = await fetch('http://localhost:8080/Usuarios/delete/porID', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(usuario)
    });
    
    if (!response.ok) {
      throw new Error('Error en la respuesta del servidor');
    }
    
    const data = await response.json();
    console.log(data);
    alert('Usuario eliminado');
    
  } catch (error) {
    alert('Error en la petición: ' + error.message);
    console.error(error);
  }
}


///ELIMINAR USUARIO POR NOMBRE
async function deleteUsuarioPorName() {
  try {
    const event = window.event;
    event.preventDefault(); // prevent default form submission behavior
    const username = document.getElementById("NOMBRE").value;
    const lastname = document.getElementById("APELLIDOS").value;
    const email = document.getElementById("EMAIL").value;
    const phone = document.getElementById("TELEFONO").value;

    // Crear un objeto usuario
    const usuario = {
      "username": username,
      "lastname": lastname,
      "email": email,
      "phone": phone,
    };
    
    
    const response = await fetch('http://localhost:8080/Usuarios/delete/nombre', {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(usuario)
    });
    
    if (!response.ok) {
      throw new Error('Error en la respuesta del servidor');
    }
    
    const data = await response.json();
    console.log(data);
    alert('Usuario creado correctamente');
    
  } catch (error) {
    alert('Error en la petición: ' + error.message);
    console.error(error);
  }
}


//ELIMINAR TODOS LOS USUARIOS
async function Eliminartodos() {
  try {
    const response = await fetch('http://localhost:8080/Usuarios/delete/todos', {
      method: 'DELETE'
    });

    if (!response.ok) {
      throw new Error('Error en la respuesta del servidor');
    }
    const data = await response.json();
    console.log(data);

    alert('Se han eliminado todos los usuarios');
    
  } catch (error) {
    console.error(error);
  }
}