import '../index';
import Layout from './Layout';
const About = () => {
    return (
        <div>
            <Layout/>      
            <TitleAbout />
        </div>
    )
}

const TitleAbout = () => {
    return (
        <div>
            <div>
                <div>
                <img className='w-96 h-48 rounded shadow' src="https://i.pinimg.com/originals/05/82/fd/0582fd0a1e5f3749e93e7263d5758513.jpg" alt="" />
                </div>
                <div>
                    <a>Nosotros</a>
                </div>
            </div>
        </div>
    )
}
export default About;