import { Route, Routes } from "react-router-dom";
import Layout from './page/Layout'
import Contacto from "./page/Contacto";
import Home from "./page/Home"
import { BrowserRouter } from "react-router-dom";
import About from "./page/About";
import Producto from './page/Productos';
function App() {
    return (
        <>                 
            <BrowserRouter>       
        
                <Routes>
                    <Route path="/" element={<Layout />} />
                    <Route path="home" element={<Home />} />
                    <Route path="producto" element={<Producto />} />
                    <Route path="contacto" element={<Contacto />} />
                    <Route path="nosotros" element={<About />} />
                </Routes>
            </BrowserRouter>
        </>
    )
}
export default App;