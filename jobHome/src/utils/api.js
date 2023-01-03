const domainPath = "http://localhost:8085";

async function get(path) {
  try {
    const resp = await fetch(domainPath + path, {
      method: "GET",
    });
    return resp;
  } catch (error) {
    console.log(error);
  }
  return null;
}

async function post(path, body) {
  try {
    const resp = await fetch(domainPath + path, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    return resp;
  } catch (error) {
    console.log(error);
  }
  return null;
}

async function put(path, body) {
  try {
    const resp = await fetch(domainPath + path, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    return resp;
  } catch (error) {
    console.log(error);
  }
  return null;
}

async function del(path, body) {
  try {
    const resp = await fetch(domainPath + path, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });
    return resp;
  } catch (error) {
    console.log(error);
  }
  return null;
}

export default {
  get,
  post,
  put,
  del,
};
