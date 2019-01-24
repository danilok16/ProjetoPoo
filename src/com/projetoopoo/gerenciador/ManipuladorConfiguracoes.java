/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetoopoo.gerenciador;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Téo
 */
public class ManipuladorConfiguracoes {
    public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./Propriedades/configuracoes.properties");
		props.load(file);
		return props;

	}
}
