export const BASE=import.meta.env.VITE_API_URL||'http://localhost:8081/api/v1';
export async function api(path,options={}){
const response=await fetch(BASE+path,{...options,headers:{'Content-Type':'application/json',...(options.headers||{})}});
if(!response.ok){let error={};
try{
    error=await response.json()

}catch{}
throw new Error(error.message|| 'HTTP ${response.status}')}
return response.json();

}