import { Outlet, Link } from "react-router-dom"
import { ValidacionCliente } from "../componentes/clientes/header";

const Layout = () => {
    return (

        <header className="flex justify-between px-4 py-4 border-b shadow-md">
            <div className="mt-auto mb-auto">
                <div className="mt-auto mb-auto">
                    <a href="#">TITULO PROYECTO</a>
                </div>
            </div>
            <div className="flex gap-4 mt-auto mb-auto">
                <div className="mt-auto mb-auto">
                    <div className="flex gap-4 text-sm menu-client">
                        <Link to="/home">Home</Link>
                        <Link to="/producto">Productos</Link>
                        <Link to="/contacto">Contacto</Link>
                        <Link to="/nosotros">nosotros</Link>
                        <div>
                            {/* Renderiza el contenido de las rutas secundarias aquí */}
                        </div>
                    </div>
                </div>
                <div className="mt-auto mb-auto">
                    <ValidacionCliente />
                </div>
            </div>
        </header>

    );
};
export default Layout;