package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        this.ventanaPrincipal = principal;
        setLayout(new BorderLayout());

        panelMapa = new PanelMapaAgregar(); 
        // TODO: Implementar el PanelMapaAgregar según sea necesario
        add(panelMapa, BorderLayout.CENTER);

        panelDetalles = new PanelEditarRestaurante(); 
        
        // TODO: Implementar el PanelEditarRestaurante con los campos requeridos
        panelBotones = new PanelBotonesAgregar(this);
        
        // TODO: Implementar el PanelBotonesAgregar con las acciones necesarias

        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.add(panelDetalles, BorderLayout.CENTER);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        add(panelSur, BorderLayout.SOUTH);

        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
        // TODO: Validar si los campos de texto y selectores tienen información válida
        String nombre = panelDetalles.getNombre(); // TODO: Manejar casos donde el nombre esté vacío
        int calificacion = panelDetalles.getCalificacion(); // TODO: Validar que la calificación esté entre 1 y 5
        boolean visitado = panelDetalles.getVisitado();

                int[] coordenadas = panelMapa.getCoordenadas();
        int x = coordenadas[0];
        int y = coordenadas[1];

        ventanaPrincipal.agregarRestaurante(nombre, calificacion, x, y, visitado);

        dispose();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
