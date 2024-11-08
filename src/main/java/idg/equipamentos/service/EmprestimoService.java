package idg.equipamentos.service;

import idg.equipamentos.persistence.EmprestimoRepository;

    public class EmprestimoService {
         private final EmprestimoRepository emprestimoRepository;

        public EmprestimoService(EmprestimoRepository emprestimoRepository) {
            this.emprestimoRepository = emprestimoRepository;
        }
}
